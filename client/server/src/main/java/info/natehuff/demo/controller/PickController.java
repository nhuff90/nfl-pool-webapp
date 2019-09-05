package info.natehuff.demo.controller;

import info.natehuff.demo.dto.Pick;
import info.natehuff.demo.dto.PickWithGame;
import info.natehuff.demo.repository.GameRepository;
import info.natehuff.demo.repository.PickRepository;
import info.natehuff.demo.utils.PickUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class PickController {
    private PickRepository pickRepository;
    GameRepository gameRepository;

    public PickController(PickRepository pickRepository, GameRepository gameRepository) {
        this.pickRepository = pickRepository;
        this.gameRepository = gameRepository;
    }

    @GetMapping("/picks")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Pick> getAllPicks() {

        return pickRepository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    @GetMapping("/picks/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<PickWithGame> getPicks(@PathVariable(value = "week") int week) {
        //return new ArrayList<>(repository.findPicksByWeek(week));
        return PickUtils.filterPicks(gameRepository.findGamesByWeek(week), pickRepository.findPicksByWeek(week));
    }

    @GetMapping("/picks/record/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getRecord(@PathVariable(value = "week") int week) {
        //return new ArrayList<>(repository.findPicksByWeek(week));
        return PickUtils.getRecord(gameRepository.findGamesByWeek(week), pickRepository.findPicksByWeek(week));
    }

    private boolean isGreat(Pick pick) {
        return !pick.getName().equals("Budweiser") &&
                !pick.getName().equals("Coors Light") &&
                !pick.getName().equals("PBR");
    }
}