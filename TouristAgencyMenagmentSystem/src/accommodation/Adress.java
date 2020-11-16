package accommodation;

public class Adress {
	private String street;
	private int streetNumber;
	private City city;
	
	public Adress() {}

	@Override
	public String toString() {
		return street + "," + streetNumber + "," + city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + streetNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Adress)) {
			return false;
		}
		Adress other = (Adress) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (street == null) {
			if (other.street != null) {
				return false;
			}
		} else if (!street.equals(other.street)) {
			return false;
		}
		if (streetNumber != other.streetNumber) {
			return false;
		}
		return true;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Adress(String street, int streetNumber, City city) {
		super();
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
	}
	public String uCSV() {
		return   street + "," + streetNumber +","+ city ;
	}
}
