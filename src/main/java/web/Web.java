package web;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Controller
public class Web {
	
	@RequestMapping("/")
	String index() {
		return "index";
	}
	
	@RequestMapping("/state") @ResponseBody
	List stationByPostCode(String name) {
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
		Query query = database.createQuery(
			"from Station where " +
			"latitude  <= :top   and latitude  >= :bottom and " +
			"longitude <= :right and longitude >= :left");
		query.setParameter("top",    top);
		query.setParameter("bottom", bottom);
		query.setParameter("left",   left);
		query.setParameter("right",  right);
		List result = query.list();
		database.close();
		return result;
	}
	
	SessionFactory factory = new Configuration()
		// .addPackage("entity")
		.addAnnotatedClass(Station.class)
		.buildSessionFactory();
}
