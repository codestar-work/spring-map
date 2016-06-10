package web;

import java.util.*;
import javax.transaction.*;
import org.springframework.data.repository.*;

@Transactional
public interface StationRepository extends CrudRepository<Station, Long> {
	List<Station> findByState(String state);
	Long countByState(String state);
}
