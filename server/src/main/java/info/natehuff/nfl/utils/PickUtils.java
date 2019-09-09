package info.natehuff.nfl.utils;

import info.natehuff.nfl.data.mysql.model.Pick;
import info.natehuff.nfl.dto.Game;
import info.natehuff.nfl.dto.PickWithGame;
import info.natehuff.nfl.dto.enums.GameProgress;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PickUtils {

    public static boolean isCovering(Game game, Pick pick) {
        double line = pick.getLine();
        if (game.getGameProgress() != GameProgress.NOT_STARTED.toString()) {
            double homeAdjustedScore = Double.parseDouble(game.getHomeScore());
            double awayAdjustedScore = Double.parseDouble(game.getAwayScore());
            if (pick.getTeam().equalsIgnoreCase(game.getHomeTeam())) {
                homeAdjustedScore = homeAdjustedScore + line;
                if (homeAdjustedScore > awayAdjustedScore) {
                    return true;
                } else {
                    return false;
                }
            } else {
                awayAdjustedScore = awayAdjustedScore + line;
                if (awayAdjustedScore > homeAdjustedScore) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public static List<PickWithGame> filterPicks(List<Game> games, List<Pick> allPicksThisWeek) {

        List<PickWithGame> picksToReturn = new ArrayList<>();
        for (Pick pick : allPicksThisWeek) {
            for (Game game : games) {
                if (game.getHomeTeam().equals(pick.getTeam()) ||
                        game.getAwayTeam().equals(pick.getTeam())) {
                    picksToReturn.add(new PickWithGame(pick, game, PickUtils.isCovering(game, pick)));
                    break;
                }
            }
        }
        return picksToReturn;
    }

    public static String getRecord(List<Game> games, List<Pick> allPicksThisWeek, int week) {
        int wins = 0;
        int losses = 0;
        List<PickWithGame> picksWithGames = filterPicks(games, allPicksThisWeek);
        for (PickWithGame pickWithGame : picksWithGames) {
            if (isCovering(pickWithGame.getGame(), pickWithGame.getPick())) {
                wins++;
            } else {
                losses++;
            }
        }
        String ret = "" + wins + "-" + losses;
        RecordFileUtils.writeWeeklyRecord(ret, week);
        return ret;
    }

    public static String getOverallRecord() {

        int wins = 0;
        int losses = 0;
        String s = "";
        try {
            s = RecordFileUtils.returnOverallRecord();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splitStr = s.split("\n");

        for(String str : splitStr) {
            String[] subsplit = str.split("-");
            wins = wins + Integer.parseInt(subsplit[0]);
            losses = losses + Integer.parseInt(subsplit[1]);
        }

        return wins + "-" + losses;
    }

    public static void main(String[] args) {
        System.out.println(getOverallRecord());
    }
}
