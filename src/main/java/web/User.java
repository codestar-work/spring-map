package web;
import javax.persistence.*;

@Entity @Table(name="users")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	public String name;
	public String email;
	public String password;
}
