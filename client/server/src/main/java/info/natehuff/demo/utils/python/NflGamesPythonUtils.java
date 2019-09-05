package info.natehuff.demo.utils.python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NflGamesUtils {

    public static BufferedReader getScores(int week) {

        String s = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader stdInput = null;

        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("python python/nfl_scores.py");

            stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            // read the output from the command
            /*System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(s);
            }*/

            // read any errors from the attempted command
            /*System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }*/
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
        System.out.println(getScores(1));
    }
}
