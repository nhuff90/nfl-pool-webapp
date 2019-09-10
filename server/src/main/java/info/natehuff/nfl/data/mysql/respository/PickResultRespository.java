package info.natehuff.nfl.data.mysql.respository;

import info.natehuff.nfl.data.mysql.model.PickResult;
import org.springframework.data.repository.CrudRepository;

public interface PickResultRespository extends CrudRepository<PickResult, Integer> {

}
