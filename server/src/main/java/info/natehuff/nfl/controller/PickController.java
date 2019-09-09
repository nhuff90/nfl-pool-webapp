package info.natehuff.nfl.controller;

import info.natehuff.nfl.data.mysql.model.Pick;
import info.natehuff.nfl.data.mysql.respository.WagerRepository;
import info.natehuff.nfl.dto.PickWithGame;
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
    private WagerRepository wagerRepository;
    //private GameRepository gameRepository;
    private GameRepositoryService gameService;

    public PickController(WagerRepository wagerRepository, GameRepositoryService gameService) {
        this.wagerRepository = wagerRepository;
        this.gameService = gameService;
    }

    @GetMapping("/picks")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Pick> getAllPicks() {

        return StreamSupport.stream(wagerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/picks/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<PickWithGame> getPicks(@PathVariable(value = "week") int week) {
        return PickUtils.filterPicks(gameService.refreshGames(week), wagerRepository.findPicksByWeek(week));
    }

    @GetMapping("/picks/record/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getRecord(@PathVariable(value = "week") int week) {
        return PickUtils.getRecord(gameService.refreshGames(week), wagerRepository.findPicksByWeek(week), week);
    }

    @GetMapping("/picks/record")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getOverallRecord() {
        return PickUtils.getOverallRecord();
    }
}
