package info.natehuff.nfl.data.mysql;

import info.natehuff.nfl.data.mysql.model.PickResult;
import info.natehuff.nfl.data.mysql.respository.PickResultRespository;
import info.natehuff.nfl.dto.PickWithGame;
import info.natehuff.nfl.dto.enums.GameProgress;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

@Configuration
@EnableAsync
public class PickResultService {
    PickResultRespository pickResultRespository;

    public PickResultService(PickResultRespository pickResultRespository) {
        this.pickResultRespository = pickResultRespository;
    }
    @Async
    public void saveCompletedResults(List<PickWithGame> picksWithGame) {
        for (PickWithGame pickWithGame : picksWithGame) {
            if (pickWithGame.getGame().getGameProgress().equalsIgnoreCase(GameProgress.FINISHED.toString())) {
                PickResult pickResult = new PickResult(pickWithGame);
                System.out.println("Saving game.");
                pickResultRespository.save(pickResult);
            }
        }
    }

    public double getWeeklyProfit(int week) {
        double weeklyProfit = 0;
        Iterable<PickResult> pickResults = pickResultRespository.findAll();
        for (PickResult pickResult : pickResults) {
            if (week == pickResult.getWeek()) {
                weeklyProfit = weeklyProfit + pickResult.getNetProfit();
            }
        }
        return weeklyProfit;
    }

    public double getOverallProfit() {
        double overallProfit = 0;
        Iterable<PickResult> pickResults = pickResultRespository.findAll();
        for (PickResult pickResult : pickResults) {
            overallProfit = overallProfit + pickResult.getNetProfit();
        }
        return overallProfit;
    }
}
