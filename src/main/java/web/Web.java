package web;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.servlet.http.*;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Controller
public class Web {

	SessionFactory factory = new Configuration()
		// .addPackage("entity")
		.addAnnotatedClass(Station.class)
		.buildSessionFactory();

	@RequestMapping("/")
	String index() {
		return "index";
	}

	@RequestMapping("/state") @ResponseBody
	List stationByState(String name) {
		Session database = factory.openSession();
		Query query = database.createQuery(
			"from Station where state = :name");
		query.setParameter("name", name);
		List result = query.list();
		database.close();
		return result;
	}

	@RequestMapping("/station-list") @ResponseBody
	List stationList(
		Double top, Double bottom,
		Double left, Double right) {
		Session database = factory.openSession();
		Query query = database.createQuery("from Station");
		List result = query.list();
		database.close();
		return result;
	}

	@RequestMapping("/search")
	String search(Model model, String data) {
		if (data == null) {
			model.addAttribute("result", new ArrayList());
		} else {
			Session database = factory.openSession();
			Query query = database.createQuery(
				"from Station where suburb like :data");
			query.setParameter("data", "%" + data + "%");
			List result = query.list();
			model.addAttribute("size", result.size());
			model.addAttribute("result", result);
			database.close();
		}
		return "search";
	}

	@RequestMapping("/search-jsp")
	String searchJsp(Model model, String data) {
		if (data == null) {
			model.addAttribute("result", new ArrayList());
		} else {
			Session database = factory.openSession();
			Query query = database.createQuery(
				"from Station where suburb like :data");
			query.setParameter("data", "%" + data + "%");
			List result = query.list();
			model.addAttribute("size", result.size());
			model.addAttribute("result", result);
			database.close();
		}
		return "search-jsp";
	}

	@RequestMapping("/search-ajax")
	String searchAjax() {
		return "search-ajax";
	}

	@RequestMapping("/search-angular")
	String searchAngular() {
		return "search-angular";
	}

	@RequestMapping("/search-angular2")
	String searchAngular2() {
		return "search-angular2";
	}

	@RequestMapping("/search-react")
	String searchReact() {
		return "search-react";
	}

	@RequestMapping("/search-ajax-result") @ResponseBody
	List searchAjaxResult(String data) {
		Session database = factory.openSession();
		Query query = database.createQuery(
			"from Station where suburb like :data");
		query.setParameter("data", "%" + data + "%");
		List result = query.list();
		database.close();
		return result;
	}

	@RequestMapping("/search-all") @ResponseBody
	List searchAll(String data) {
		Session database = factory.openSession();
		Query query = database.createQuery(
			"from Station");
		List result = query.list();
		database.close();
		return result;
	}
}
