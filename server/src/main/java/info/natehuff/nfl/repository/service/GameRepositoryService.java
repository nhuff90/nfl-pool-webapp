package info.natehuff.nfl.repository.service;

import info.natehuff.nfl.dto.Game;
import info.natehuff.nfl.utils.NflGamesUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GameRepositoryService {

    public GameRepositoryService() {}

    public List<Game> refreshGames(int week) {
        List<Game> games = null;
        try {
            games = NflGamesUtils.readGamesByWeek(week);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return games;
    }

    public List<Game> getAllActiveGames(int week) {
        List<Game> activeGames = null;
        try {
            activeGames = NflGamesUtils.getActiveGamesByWeek(week);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return activeGames;
    }
}
