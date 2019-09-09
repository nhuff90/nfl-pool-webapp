package info.natehuff.nfl.data.mysql.respository;

import info.natehuff.nfl.data.mysql.model.Pick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WagerRepository extends JpaRepository<Pick, Integer> {

    @Query("SELECT p FROM wager p where p.week = :week")
    List<Pick> findPicksByWeek(@Param("week") Integer week);

}
