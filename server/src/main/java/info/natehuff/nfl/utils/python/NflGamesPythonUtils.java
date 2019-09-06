package info.natehuff.nfl.utils.python;

import info.natehuff.nfl.dto.enums.GameProgress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class NflGamesPythonUtils {

    /*public static BufferedReader getScoresByWeek(int week) {

        String s = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader stdInput = null;

        try {
            String pythonScriptCommand = "python python/nfl_scores" + week + ".py";
            Process p = Runtime.getRuntime().exec(pythonScriptCommand);

            stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }

        return stdInput;
    }*/

    /**
     * Returns games by week. Pass in Game Progress
     * @param week
     * @param gameProgress
     * @return
     */
    public static BufferedReader getGamesByWeek(int week, GameProgress gameProgress) {

        switch (gameProgress) {
            case NOT_STARTED:
                return getGamesByWeek(week, 0, 0);
            case IN_PROGRESS:
                return getGamesByWeek(week, 1, 0);
            case FINISHED:
                return getGamesByWeek(week, 0, 1);
             default:
                 return getAllGamesByWeek(week);
        }
    }

    public static BufferedReader getAllGamesByWeek(int week) {
        return getGamesByWeek(week, null, null);
    }

    private static BufferedReader getGamesByWeek(int week, Integer active, Integer completed) {
        BufferedReader stdInput = null;

        try {
            String pythonScriptCommand;
            if (active == null && completed == null) {
                pythonScriptCommand = "python python/nfl-games.py " + week;
            } else {
                pythonScriptCommand = "python python/nfl-games.py " + week + " " + active + " " + completed;
            }
            Process p = Runtime.getRuntime().exec(pythonScriptCommand);

            stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }

        return stdInput;
    }


    public static void main(String[] args) {
        System.out.println("Here is the standard output of the command:\n");
        System.out.println(getGamesByWeek(1, GameProgress.NOT_STARTED).lines().collect(Collectors.joining()));
    }
}
