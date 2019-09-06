package info.natehuff.nfl.runner;

import info.natehuff.nfl.dto.Game;
import info.natehuff.nfl.repository.GameRepository;
import info.natehuff.nfl.utils.NflGamesUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GameCommandLineRunner implements CommandLineRunner {

    private final GameRepository repository;

    public GameCommandLineRunner(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Game> games = NflGamesUtils.readGamesByWeek(2);

        System.out.println(Arrays.toString(games.toArray()));

        // Top beers from https://www.beeradvocate.com/lists/top/
        games.forEach(game ->
                repository.save(game)
        );

        repository.findAll().forEach(System.out::println);
    }
}
