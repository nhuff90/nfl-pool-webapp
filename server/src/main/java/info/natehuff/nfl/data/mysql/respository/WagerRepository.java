package info.natehuff.nfl.data.mysql.respository;

import info.natehuff.nfl.data.mysql.model.Wager;
import org.springframework.data.repository.CrudRepository;

public interface WagerRepository extends CrudRepository<Wager, Long> {

}
