package web;

import javax.transaction.*;
import org.springframework.data.repository.*;

@Transactional
public interface StationDao extends CrudRepository<Station, Long> {

}
