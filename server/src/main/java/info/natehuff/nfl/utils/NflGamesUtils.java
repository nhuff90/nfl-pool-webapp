package info.natehuff.nfl.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.natehuff.nfl.dto.Game;
import info.natehuff.nfl.dto.enums.GameProgress;
import info.natehuff.nfl.utils.python.NflGamesPythonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class NflGamesUtils {
    public static ArrayList<Game> readGamesByWeek(int week)
            throws IOException {
        ArrayList<Game> games = new ArrayList<>();
        games.addAll(bufferToGamesList(NflGamesPythonUtils.getGamesByWeek(week, GameProgress.NOT_STARTED), GameProgress.NOT_STARTED));
        games.addAll(bufferToGamesList(NflGamesPythonUtils.getGamesByWeek(week, GameProgress.IN_PROGRESS), GameProgress.IN_PROGRESS));
        games.addAll(bufferToGamesList(NflGamesPythonUtils.getGamesByWeek(week, GameProgress.FINISHED), GameProgress.FINISHED));

        return games;
    }

    public static ArrayList<Game> getActiveGamesByWeek(int week)
            throws IOException {
        return bufferToGamesList(NflGamesPythonUtils.getGamesByWeek(week, GameProgress.IN_PROGRESS), GameProgress.IN_PROGRESS);

    }

    public static ArrayList<Game> bufferToGamesList(BufferedReader gamesStrBuffer, GameProgress gameProgress) throws IOException {
        ArrayList<Game> games = new ArrayList<>();
        String line = null;
        while ((line = gamesStrBuffer.readLine()) != null) {

            System.out.println("Game List Line -- " + line);
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> map = mapper.readValue(line, Map.class);
            String[] splitString = line.split("\\s+");

            Game game = new Game(map.get("eid").toString(), Integer.parseInt(map.get("week").toString()), map.get("homeTeam").toString(),
                    map.get("homeScore").toString(), map.get("awayTeam").toString(), map.get("awayScore").toString(), gameProgress.toString());
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
