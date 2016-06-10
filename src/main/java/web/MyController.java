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
		return stations.findAll();
	}
	
	@Autowired
	private StationDao stations;
}
