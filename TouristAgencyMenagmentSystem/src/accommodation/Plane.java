package accommodation;

public class Plane extends TransportType{
	private FlightClass flightClass;
	
	public Plane() {}

	public Plane(boolean mealIncluded, DepartureAdress departureAdress, DestinationAdress destinationAdress, FlightClass flightClass) {
		super(mealIncluded, departureAdress, destinationAdress);
		this.flightClass = flightClass;
	}

	public FlightClass getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(FlightClass flightClass) {
		this.flightClass = flightClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((flightClass == null) ? 0 : flightClass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Plane)) {
			return false;
		}
		Plane other = (Plane) obj;
		if (flightClass != other.flightClass) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return  isMealIncluded() + "," + getDepartureAdress() +","+ getDestinationAdress() +"," + flightClass;
	}

	public String uCSV() {
		return   isMealIncluded() + "," + getDepartureAdress() +","+ getDestinationAdress() +"," + flightClass;
	}
}
	

