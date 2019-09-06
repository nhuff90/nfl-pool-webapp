package info.natehuff.nfl.repository;

import info.natehuff.nfl.dto.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface GameRepository extends CrudRepository<Game, Long> {

    @Query("SELECT g FROM Game g where g.week = :week")
    List<Game> findGamesByWeek(@Param("week") Integer week);
}
