package info.natehuff.nfl.controller;

import info.natehuff.nfl.data.mysql.PickResultService;
import info.natehuff.nfl.data.mysql.WeeklyRecordService;
import info.natehuff.nfl.data.mysql.model.Pick;
import info.natehuff.nfl.data.mysql.respository.PickRepository;
import info.natehuff.nfl.data.mysql.respository.WeeklyRecordRepository;
import info.natehuff.nfl.dto.AnnualStats;
import info.natehuff.nfl.dto.PickWithGame;
import info.natehuff.nfl.dto.WeeklyStats;
import info.natehuff.nfl.repository.service.GameRepositoryService;
import info.natehuff.nfl.utils.PickUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class PickController {
    private PickRepository pickRepository;
    private GameRepositoryService gameService;
    private PickResultService pickResultService;
    private WeeklyRecordRepository weeklyRecordRepository;
    private WeeklyRecordService weeklyRecordService;

    public PickController(PickRepository pickRepository, GameRepositoryService gameService,
                          PickResultService pickResultService, WeeklyRecordRepository weeklyRecordRepository,
                          WeeklyRecordService weeklyRecordService) {
        this.pickRepository = pickRepository;
        this.gameService = gameService;
        this.pickResultService = pickResultService;
        this.weeklyRecordRepository = weeklyRecordRepository;
        this.weeklyRecordService = weeklyRecordService;
    }

    @GetMapping("/picks")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Pick> getAllPicks() {

        return StreamSupport.stream(pickRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/picks/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<PickWithGame> getNonParleyPicks(@PathVariable(value = "week") int week) {
        List<PickWithGame> picksWithGame = PickUtils.filterPicks(gameService.getGames(week), pickRepository.findNonParleyPicksByWeek(week));
        pickResultService.saveCompletedResults(picksWithGame);
        return picksWithGame;
    }

    @GetMapping("/picks/parley/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<List<PickWithGame>> getParleyPicks(@PathVariable(value = "week") int week) {
        Collection<List<PickWithGame>> picksWithGame = PickUtils.filterParleyPicks(gameService.getGames(week), pickRepository.findParleyPicksByWeek(week));
        pickResultService.saveCompletedParleyResults(picksWithGame);
        return picksWithGame;
    }

    @GetMapping("/picks/weeklyStats/{week}")
    @CrossOrigin(origins = "http://localhost:4200")
    public WeeklyStats getRecord(@PathVariable(value = "week") int week) {
        weeklyRecordService.saveWeeklyRecord(week, PickUtils.filterPicks(gameService.getGames(week),
                pickRepository.findNonParleyPicksByWeek(week)),
                PickUtils.filterParleyPicks(gameService.getGames(week), pickRepository.findParleyPicksByWeek(week)));
        return new WeeklyStats(weeklyRecordRepository.findById(week).get(),
                pickResultService.getWeeklyProfit(week));
    }

    @GetMapping("/picks/annualStats")
    @CrossOrigin(origins = "http://localhost:4200")
    public AnnualStats getAnnualStats() {
        return new AnnualStats(weeklyRecordService.getOverallRecord(),
                pickResultService.getOverallProfit());
    }
}
