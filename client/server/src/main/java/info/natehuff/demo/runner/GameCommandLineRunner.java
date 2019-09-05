package info.natehuff.demo.runner;

import info.natehuff.demo.demo.Beer;
import info.natehuff.demo.dto.Game;
import info.natehuff.demo.dto.Pick;
import info.natehuff.demo.repository.GameRepository;
import info.natehuff.demo.utils.ReadGamesFile;
import info.natehuff.demo.utils.ReadPicksFile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
public class GameCommandLineRunner implements CommandLineRunner {

    private final GameRepository repository;

    public GameCommandLineRunner(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        // Top beers from https://www.beeradvocate.com/lists/top/
        List<Game> games = ReadGamesFile.readGamesFile();

        System.out.println(Arrays.toString(games.toArray()));

        // Top beers from https://www.beeradvocate.com/lists/top/
        games.forEach(game ->
                repository.save(game)
        );

        repository.findAll().forEach(System.out::println);
    }
}