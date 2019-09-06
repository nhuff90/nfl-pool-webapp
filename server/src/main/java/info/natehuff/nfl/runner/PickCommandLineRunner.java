package info.natehuff.nfl.runner;

import info.natehuff.nfl.dto.Pick;
import info.natehuff.nfl.repository.PickRepository;
import info.natehuff.nfl.utils.ReadPicksFile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PickCommandLineRunner implements CommandLineRunner {

    private final PickRepository repository;

    public PickCommandLineRunner(PickRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Pick> picks = ReadPicksFile.readPicksFile();

        System.out.println(Arrays.toString(picks.toArray()));

        // Top beers from https://www.beeradvocate.com/lists/top/
        picks.forEach(pick ->
                repository.save(pick)
        );
        repository.findAll().forEach(System.out::println);
    }
}
