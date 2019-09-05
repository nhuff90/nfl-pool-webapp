package info.natehuff.demo.utils;

import info.natehuff.demo.dto.Pick;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadPicksFile {

    public static ArrayList<Pick> readPicksFile()
            throws IOException {
        ArrayList<Pick> picks = new ArrayList<>();
        String file = "data/picks.dat";

        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n");

        while(scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            String[] splitString = currentLine.split("\\s+");

            Pick pick = new Pick(TeamMapper.convert(splitString[1]), splitString[splitString.length - 1], 1);
            picks.add(pick);
        }

        return picks;
    }

    public static ArrayList<Pick> readPicksFileByWeek(int week)
            throws IOException {
        ArrayList<Pick> picks = new ArrayList<>();
        String fileStr = readInFile("data/picks.dat");

        String[] splitString = fileStr.split("----");

        String s = splitString[week - 1];
        s = s.substring(1, s.length() - 1);

        for (String gameStr : s.split("\n")) {
            String[] splitStringGame = gameStr.split("\\s+");

            Pick pick = new Pick(TeamMapper.convert(splitStringGame[0]), splitStringGame[splitString.length - 1], 1);
            picks.add(pick);
        }

        return picks;
    }

    public static String readInFile(String file)
            throws IOException {
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n");

        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        while (scanner.hasNext()) {
            sb.append(scanner.nextLine() + "\n");
        }

        return sb.toString();
    }
}
