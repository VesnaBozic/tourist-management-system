package accommodation;

import java.util.Collection;


public class Country {
	private String countryName;
	private Collection<City> cities;
	
	public Country() {}

	@Override
	public String toString() {
		return  countryName;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Country)) {
			return false;
		}
		Country other = (Country) obj;
		if (cities == null) {
			if (other.cities != null) {
				return false;
			}
		} else if (!cities.equals(other.cities)) {
			return false;
		}
		if (countryName == null) {
			if (other.countryName != null) {
				return false;
			}
		} else if (!countryName.equals(other.countryName)) {
			return false;
		}
		return true;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Collection<City> getCities() {
		return cities;
	}

	public void setCities(Collection<City> cities) {
		this.cities = cities;
	}

	public Country(String countryName, Collection<City> cities) {
		super();
		this.countryName = countryName;
		this.cities = cities;
	}
	
	public String uCSV() {
		return   countryName + "," + cities ;
	}
}
