package info.natehuff.demo.repository.service;

import info.natehuff.demo.dto.Game;
import info.natehuff.demo.utils.NflGamesUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GamesService {

    public GamesService() {}

    public List<Game> getGames(int week) throws IOException {
        return NflGamesUtils.readGamesByWeek(2);
    }
}
