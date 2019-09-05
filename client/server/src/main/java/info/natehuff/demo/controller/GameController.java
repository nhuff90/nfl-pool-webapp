package info.natehuff.demo.controller;

import info.natehuff.demo.dto.Game;
import info.natehuff.demo.repository.GameRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class GameController {
    private GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/games")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Game> getAllGames() {

        return new ArrayList<>(repository.findAll());
    }

    @GetMapping("/games/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Game> getGamesByWeek(@PathVariable(value="week") int week) {

        return new ArrayList<>(repository.findGamesByWeek(week));
    }
}