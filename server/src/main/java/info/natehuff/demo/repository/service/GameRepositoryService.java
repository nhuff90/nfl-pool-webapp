package info.natehuff.demo.repository.service;

import info.natehuff.demo.dto.Game;
import info.natehuff.demo.repository.GameRepository;
import info.natehuff.demo.utils.NflGamesUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GameRepositoryService {

    private final GameRepository repository;

    public GameRepositoryService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> refreshGames(int week) {
        List<Game> games = null;
        try {
            games = NflGamesUtils.readGamesByWeek(week);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*System.out.println(Arrays.toString(games.toArray()));
        games.forEach(game ->
                repository.save(game)
        );*/

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
