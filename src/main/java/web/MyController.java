package web;
import java.util.*;
import javax.servlet.http.*;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Controller
public class MyController {
	
	@RequestMapping("/list") @ResponseBody
	Iterable list() {
		return repository.findAll();
	}
	
	@RequestMapping("/find-by") @ResponseBody
	List<Station> find(String state) {
		return repository.findByState(state);
	}
	
	@RequestMapping("/count") @ResponseBody
	Long count(String state) {
		return repository.countByState(state);
	}
	
	@Autowired
	private StationRepository repository;
}
