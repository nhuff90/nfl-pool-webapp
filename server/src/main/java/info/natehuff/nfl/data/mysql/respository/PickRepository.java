package info.natehuff.nfl.data.mysql.respository;

import info.natehuff.nfl.data.mysql.model.Pick;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PickRepository extends CrudRepository<Pick, Integer> {

    @Query("SELECT p FROM pick p where p.week = :week")
    List<Pick> findPicksByWeek(@Param("week") Integer week);

}