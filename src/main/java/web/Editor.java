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
public class Editor {

	SessionFactory factory = new Configuration()
		// .addPackage("entity")
		.addAnnotatedClass(Station.class)
		.addAnnotatedClass(User.class)
		.buildSessionFactory();

	@RequestMapping("/editor")
	String editor(HttpSession session, Model model, String data) {
		if (session.getAttribute("user") == null) {
			return "redirect:/login";
		} else {
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
			return "editor";
		}
	}

	@RequestMapping("/login")
	String login() {
		return "login";
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	String login(HttpSession session, String email, String password) {
		Session database = factory.openSession();
		Query query = database.createQuery(
			"from User where email = :email and password = :password");
		query.setParameter("email", email);
		query.setParameter("password", encode(password));
		List list = query.list();
		if (list.size() == 1) {
			User user = (User)list.get(0);
			session.setAttribute("user", user);
			database.close();
			return "redirect:/editor";
		} else {
			return "login";
		}
	}

	@RequestMapping("/logout")
	String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/";
	}

	String encode(String s) {
		String result = "";
		try {
			java.security.MessageDigest digest = java.security.
				MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(s.getBytes("UTF-8"));
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					result += '0';
				result += hex;
			}
		} catch (Exception e) {}
		return result;
	}

	@RequestMapping("/edit-item")
	String editItem(HttpSession session, Model model, Long id) {
		if (session.getAttribute("user") == null) {
			return "redirect:/login";
		} else {
			if (id == null) {
				model.addAttribute("items", new ArrayList());
			} else {
				Session database = factory.openSession();
				Query query = database.createQuery(
					"from Station where id = :id");
				query.setParameter("id", id);
				List result = query.list();
				model.addAttribute("items", result);
				database.close();
			}
			return "edit-item";
		}
	}

	@RequestMapping(value="/edit-item", method=RequestMethod.POST)
	String register(HttpSession session, Model model,
		Long id, String suburb) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		} else {
			Session database = factory.openSession();
			Query query = database.createQuery(
				"update Station set suburb = :suburb where id = :id");
			query.setParameter("suburb", suburb);
			query.setParameter("id", id);
			query.executeUpdate();
			database.close();
			return "redirect:/editor";
		}
	}
}
