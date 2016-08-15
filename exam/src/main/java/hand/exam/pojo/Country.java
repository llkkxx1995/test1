package hand.exam.pojo;

import java.util.Date;
import java.util.List;

public class Country {
    private Short country_id;

    private String country;

    private Date last_update;

    private List<City> citys;

	public Short getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Short country_id) {
		this.country_id = country_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + ", last_update=" + last_update
				+ ", citys=" + citys + "]";
	}
   
    
}