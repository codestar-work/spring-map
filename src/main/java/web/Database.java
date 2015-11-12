package web;

import java.sql.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
class Database {

	@RequestMapping("/data")
	ArrayList readData() {
		String connection = server + "&user=" + user +
			"&password=" + password;
		String sql = "select * from stations";
		ArrayList list = new ArrayList();
		try {
			Class.forName(driver).newInstance();
			Connection cn = DriverManager.getConnection(connection);
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Station s = new Station();
				s.id = rs.getLong("id");
				s.address = rs.getString("address");
				list.add(s);
			}
			rs.close();
			ps.close();
			cn.close();
		} catch (Exception e) {}
		return list;
	}

	@Value("${my.jdbc.driver}")
	String driver;
	@Value("${my.jdbc.server}")
	String server;
	@Value("${my.jdbc.user}")
	String user;
	@Value("${my.jdbc.password}")
	String password;

}
