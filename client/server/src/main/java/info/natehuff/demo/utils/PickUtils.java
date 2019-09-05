package info.natehuff.demo.utils;

import info.natehuff.demo.dto.Game;
import info.natehuff.demo.dto.Pick;
import info.natehuff.demo.dto.PickWithGame;

import java.util.ArrayList;
import java.util.List;

public class PickUtils {

    public static boolean isCovering(Game game, Pick pick) {
        String lineTemp = pick.getLine();
        lineTemp = (lineTemp.startsWith("+") ? lineTemp.substring(1) : lineTemp);
        float line = Float.parseFloat(lineTemp);
        float homeAdjustedScore = game.getHomeScore();
        float awayAdjustedScore = game.getAwayScore();
        if (pick.getName().equalsIgnoreCase(game.getHomeTeam())) {
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
    }

    public static List<PickWithGame> filterPicks(List<Game> games, List<Pick> allPicksThisWeek) {

        List<PickWithGame> picksToReturn = new ArrayList<>();
        for (Pick pick : allPicksThisWeek) {
            for (Game game : games) {
                if (game.getHomeTeam().equals(pick.getName()) ||
                        game.getAwayTeam().equals(pick.getName())) {
                    picksToReturn.add(new PickWithGame(pick, game, PickUtils.isCovering(game, pick)));
                    break;
                }
            }
        }
        return picksToReturn;
    }

    public static String getRecord(List<Game> games, List<Pick> allPicksThisWeek) {
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
        return "" + wins + "-" + losses;
    }
}
