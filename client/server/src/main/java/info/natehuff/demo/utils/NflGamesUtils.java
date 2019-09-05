package info.natehuff.demo.utils;

import info.natehuff.demo.dto.Game;
import info.natehuff.demo.dto.enums.GameProgress;
import info.natehuff.demo.utils.python.NflGamesUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadGamesFile {

    /*public static ArrayList<Game> readGamesFile()
            throws IOException {
        ArrayList<Game> games = new ArrayList<>();
        String file = "data/games.dat";

        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n");

        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            String[] splitString = currentLine.split("\\s+");


            Game game = new Game(splitString[0],
                    Integer.parseInt(splitString[1].substring(splitString[1].indexOf("(") + 1, splitString[1].indexOf(")"))),
                    splitString[splitString.length - 2],
                    Integer.parseInt(splitString[splitString.length - 1].substring(splitString[splitString.length - 1].indexOf("(") + 1,
                            splitString[splitString.length - 1].indexOf(")"))), 1, GameProgress.FINISHED.toString());
            games.add(game);
        }

        return games;
    }*/

    public static ArrayList<Game> readGamesByWeek(int week)
            throws IOException {
        ArrayList<Game> games = new ArrayList<>();
        BufferedReader gamesStrBuffer = NflGamesUtils.getScores(week);

        String line = null;
        while ((line = gamesStrBuffer.readLine()) != null) {
            String[] splitString = line.split("\\s+");


            Game game = new Game(splitString[0],
                    Integer.parseInt(splitString[1].substring(splitString[1].indexOf("(") + 1, splitString[1].indexOf(")"))),
                    splitString[splitString.length - 2],
                    Integer.parseInt(splitString[splitString.length - 1].substring(splitString[splitString.length - 1].indexOf("(") + 1,
                            splitString[splitString.length - 1].indexOf(")"))), 1, GameProgress.FINISHED.toString());
            games.add(game);
        }

        return games;
    }

    public static void main(String[] args) {
        System.out.println("Here is Read game file:\n");
        try {
            System.out.println(readGamesByWeek(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
