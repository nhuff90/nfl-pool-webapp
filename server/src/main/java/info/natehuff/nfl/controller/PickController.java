package info.natehuff.nfl.controller;

import info.natehuff.nfl.dto.Pick;
import info.natehuff.nfl.dto.PickWithGame;
import info.natehuff.nfl.repository.GameRepository;
import info.natehuff.nfl.repository.PickRepository;
import info.natehuff.nfl.repository.service.GameRepositoryService;
import info.natehuff.nfl.utils.PickUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class PickController {
    private PickRepository pickRepository;
    //private GameRepository gameRepository;
    private GameRepositoryService gameService;

    public PickController(PickRepository pickRepository, GameRepository gameRepository, GameRepositoryService gameService) {
        this.pickRepository = pickRepository;
        //this.gameRepository = gameRepository;
        this.gameService = gameService;
    }

    @GetMapping("/picks")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Pick> getAllPicks() {

        return StreamSupport.stream(pickRepository.findAll().spliterator(), false)
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    @GetMapping("/picks/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<PickWithGame> getPicks(@PathVariable(value = "week") int week) {
        return PickUtils.filterPicks(gameService.refreshGames(week), pickRepository.findPicksByWeek(week));
    }

    @GetMapping("/picks/record/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getRecord(@PathVariable(value = "week") int week) {
        return PickUtils.getRecord(gameService.refreshGames(week), pickRepository.findPicksByWeek(week), week);
    }

    @GetMapping("/picks/record")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getOverallRecord() {
        return PickUtils.getOverallRecord();
    }

    private boolean isGreat(Pick pick) {
        return !pick.getName().equals("Budweiser") &&
                !pick.getName().equals("Coors Light") &&
                !pick.getName().equals("PBR");
    }
}
