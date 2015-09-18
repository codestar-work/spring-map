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


/*
create table users (
  id         serial,
  email      nvarchar(200) unique,
  password   varchar(2048),
  name       nvarchar(2048)
);

insert into users(name, email, password)
  values('User', 'user@codestar.work', sha2('password', 256));
*/
