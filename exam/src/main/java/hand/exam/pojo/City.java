package hand.exam.pojo;

import java.util.Date;
import java.util.List;

public class City {
    private Short city_id;

    private String city;

    private Short country_id;

    private Date last_update;

    private List<Address> addresses;

	public Short getCity_id() {
		return city_id;
	}

	public void setCity_id(Short city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Short getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Short country_id) {
		this.country_id = country_id;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + ", country_id=" + country_id + ", last_update="
				+ last_update + ", addresses=" + addresses + "]";
	}

    
    
}