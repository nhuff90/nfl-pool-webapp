package info.natehuff.nfl.controller;

import com.google.common.collect.Lists;
import info.natehuff.nfl.dto.Game;
import info.natehuff.nfl.repository.GameRepository;
import info.natehuff.nfl.repository.service.GameRepositoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GameController {
    private GameRepository repository;
    private GameRepositoryService gameService;

    public GameController(GameRepository repository, GameRepositoryService gameService) {
        this.repository = repository;
        this.gameService = gameService;
    }

    @GetMapping("/games")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Game> getAllGames() {

        return Lists.newArrayList(repository.findAll());
    }

    @GetMapping("/games/active/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Game> getAllActiveGames(@PathVariable(value="week") int week) {

        return gameService.getAllActiveGames(week);
    }

    @GetMapping("/games/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Game> getGamesByWeek(@PathVariable(value="week") int week) {
        return gameService.refreshGames(week);
    }
}
