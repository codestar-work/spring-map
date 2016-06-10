package web;

import java.util.*;
import javax.transaction.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.jpa.repository.*;

@Transactional
public interface StationRepository extends CrudRepository<Station, Long> {
	List<Station> findByState(String name);
	Long countByState(String state);
	@Query("select s from Station s where s.suburb like :name")
	List<Station> showSimilar(@Param("name")String name);
}
