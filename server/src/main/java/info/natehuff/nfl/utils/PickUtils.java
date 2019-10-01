package info.natehuff.nfl.utils;

import info.natehuff.nfl.data.mysql.model.Pick;
import info.natehuff.nfl.dto.Game;
import info.natehuff.nfl.dto.PickWithGame;
import info.natehuff.nfl.dto.enums.GameProgress;

import java.io.IOException;
import java.util.*;

public class PickUtils {

    public static PickWithGame.Covered isCovering(Game game, Pick pick) {
        double line = pick.getLine();
        if (game.getGameProgress() != GameProgress.NOT_STARTED.toString()) {
            double homeAdjustedScore = Double.parseDouble(game.getHomeScore());
            double awayAdjustedScore = Double.parseDouble(game.getAwayScore());
            if (pick.getTeam().equalsIgnoreCase(game.getHomeTeam())) {
                homeAdjustedScore = homeAdjustedScore + line;
                if (homeAdjustedScore > awayAdjustedScore) {
                    return PickWithGame.Covered.COVERED;
                } else if (homeAdjustedScore == awayAdjustedScore) {
                    return PickWithGame.Covered.TIED;
                } else {
                    return PickWithGame.Covered.LOSS;
                }
            } else {
                awayAdjustedScore = awayAdjustedScore + line;
                if (awayAdjustedScore > homeAdjustedScore) {
                    return PickWithGame.Covered.COVERED;
                } else if (homeAdjustedScore == awayAdjustedScore) {
                    return PickWithGame.Covered.TIED;
                } else {
                    return PickWithGame.Covered.LOSS;
                }
            }
        } else {
            return PickWithGame.Covered.LOSS;
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

    public static Collection<List<PickWithGame>> filterParleyPicks (List<Game> games, List<Pick> parleyPicksThisWeek) {
        Map<String, List<PickWithGame>> mapToReturn = new HashMap<>();
        for (Pick pick : parleyPicksThisWeek) {
            for (Game game : games) {
                if (game.getHomeTeam().equals(pick.getTeam()) ||
                        game.getAwayTeam().equals(pick.getTeam())) {

                    if (mapToReturn.get(pick.getParleyId()) == null) {
                        List<PickWithGame> picksToReturn = new ArrayList<>();
                        picksToReturn.add(new PickWithGame(pick, game, PickUtils.isCovering(game, pick)));
                        mapToReturn.put(pick.getParleyId(), picksToReturn);
                    } else {
                        mapToReturn.get(pick.getParleyId()).add(new PickWithGame(pick, game, PickUtils.isCovering(game, pick)));
                    }

                    break;
                }
            }
        }
        return new ArrayList(mapToReturn.values());
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
