package info.natehuff.nfl.data.mysql;

import info.natehuff.nfl.data.mysql.model.PickResult;
import info.natehuff.nfl.dto.Record;
import info.natehuff.nfl.data.mysql.model.WeeklyRecord;
import info.natehuff.nfl.data.mysql.respository.WeeklyRecordRepository;
import info.natehuff.nfl.dto.PickWithGame;
import info.natehuff.nfl.dto.enums.GameProgress;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

@Configuration
@EnableAsync
public class WeeklyRecordService {
    WeeklyRecordRepository weeklyRecordRepository;

    public WeeklyRecordService(WeeklyRecordRepository weeklyRecordRepository) {
        this.weeklyRecordRepository = weeklyRecordRepository;
    }
    @Async
    public void saveWeeklyRecord(int week, Integer[] nonParleyRecord, Integer[] parleyRecord) {
        WeeklyRecord weeklyRecord = new WeeklyRecord(week, wins, losses);
        weeklyRecordRepository.save(weeklyRecord);
    }

    @Async
    public Integer[] getNonParleyRecord(List<PickWithGame> picksWithGame) {

        Integer[] intArray = new Integer[2];
        int wins = 0;
        int losses = 0;
        int week = 0;

        for (PickWithGame pickWithGame : picksWithGame) {
            week = pickWithGame.getGame().getWeek();
            if (pickWithGame.getGame().getGameProgress().equalsIgnoreCase(GameProgress.FINISHED.toString())) {
                if (pickWithGame.isCovering()) {
                    wins++;
                } else {
                    losses++;
                }
            }
        }
        intArray[0] = wins;
        intArray[1] = losses;
        return intArray;
    }

    @Async
    public Integer[] getParleyRecord(List<PickWithGame> picksWithGame) {

        Integer[] intArray = new Integer[2];
        int wins = 0;
        int losses = 0;
        int week = 0;

        for (List<PickWithGame> pickWithGameList : picksWithGame) {
            boolean allGamesComplete = true;
            boolean allPicksCovered = true;
            PickWithGame savedPickWithGame = null;
            for (PickWithGame pickWithGame : pickWithGameList) {
                if (!pickWithGame.getGame().getGameProgress().equalsIgnoreCase(GameProgress.FINISHED.toString())) {
                    allGamesComplete = false;
                    break;
                }
                if (!pickWithGame.isCovering()) {
                    allPicksCovered = false;
                }
                savedPickWithGame = pickWithGame;
            }
            if (allGamesComplete && savedPickWithGame != null) {
                System.out.println("Saving parley game.");
                pickResultRespository.save(new PickResult(savedPickWithGame, allPicksCovered));
            }
        }

    }

    public Record getOverallRecord() {
        Record record = new Record(0,0);
        Iterable<WeeklyRecord> weeklyRecords = weeklyRecordRepository.findAll();
        for (WeeklyRecord weeklyRecord : weeklyRecords) {
            record.setWins(record.getWins() + weeklyRecord.getWins());
            record.setLosses(record.getLosses() + weeklyRecord.getLosses());
        }
        return record;
    }
}
