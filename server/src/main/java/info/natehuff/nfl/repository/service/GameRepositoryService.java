package info.natehuff.nfl.repository.service;

import info.natehuff.nfl.dto.Game;
import info.natehuff.nfl.utils.NflGamesUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameRepositoryService {

    public GameRepositoryService() {}

    Map<Integer, List<Game>> gameMap = new HashMap<>();
    Map<Integer, List<Game>> activeGameMap = new HashMap<>();
    int[] weeks = {1,2,3,4,5};

    @Async
    void init() {
        System.out.println("GameRepositoryService initialization logic ...");
        for (int week : weeks) {
            try {
                gameMap.put(week, NflGamesUtils.readGamesByWeek(week));
                activeGameMap.put(week, NflGamesUtils.getActiveGamesByWeek(week));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Game> refreshGames(int week) {
        List<Game> games = null;
        try {
            games = NflGamesUtils.readGamesByWeek(week);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return games;
    }

    public List<Game> getGames(int week) {
        return gameMap.get(week);
    }

    public List<Game> getAllActiveGames(int week) {
        return activeGameMap.get(week);
        /*List<Game> activeGames = null;
        try {
            activeGames = NflGamesUtils.getActiveGamesByWeek(week);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return activeGames;*/
    }
}
@Component
class SampleBeanInititalizer {

    private final GameRepositoryService bean;

    public SampleBeanInititalizer(GameRepositoryService bean) {
        this.bean = bean;
    }

    @PostConstruct
    public void initialize() {
        bean.init();
    }
}
