package Model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@Table(name="country")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country_id")
	private int countryId;

	private String country;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="country")
	private Set<City> cities;

    public Country() {
    }

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
}