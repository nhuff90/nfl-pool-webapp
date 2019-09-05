package info.natehuff.demo.repository;

import info.natehuff.demo.dto.Pick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PickRepository extends JpaRepository<Pick, Long> {

    @Query("SELECT p FROM Pick p where p.week = :week")
    List<Pick> findPicksByWeek(@Param("week") Integer week);
}