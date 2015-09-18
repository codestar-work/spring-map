package web;
import javax.persistence.*;

@Entity @Table(name="stations")
public class Station {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	public String state;
	public String suburb;
	public String address;
	public String postcode;
	public Double latitude;
	public Double longitude;

	public String getSuburb() {
		return suburb;
	}
	public Long getId() {
		return id;
	}
}
