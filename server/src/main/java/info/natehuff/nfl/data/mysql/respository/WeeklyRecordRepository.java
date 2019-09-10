package info.natehuff.nfl.data.mysql.respository;

import info.natehuff.nfl.data.mysql.model.WeeklyRecord;
import org.springframework.data.repository.CrudRepository;

public interface WeeklyRecordRepository extends CrudRepository<WeeklyRecord, Integer> {
}
