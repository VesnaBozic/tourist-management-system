package accommodation;

import travelPackage.Purchasable;

public abstract class TransportType implements Purchasable {
	private boolean mealIncluded;
	private DepartureAdress departureAdress;
	private DestinationAdress destinationAdress;
	
	public TransportType() {}

	public TransportType(boolean mealIncluded, DepartureAdress departureAdresss, DestinationAdress destinationAdress) {
		super();
		this.mealIncluded = mealIncluded;
		this.departureAdress = departureAdresss;
		this.destinationAdress = destinationAdress;
	}

	public boolean isMealIncluded() {
		return mealIncluded;
	}

	public void setMealIncluded(boolean mealIncluded) {
		this.mealIncluded = mealIncluded;
	}

	public DepartureAdress getDepartureAdress() {
		return departureAdress;
	}

	public void setDepartureAdress(DepartureAdress departureAdress) {
		this.departureAdress = departureAdress;
	}

	public DestinationAdress getDestinationAdress() {
		return destinationAdress;
	}

	public void setDestinationAdress(DestinationAdress destinationAdress) {
		this.destinationAdress = destinationAdress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureAdress == null) ? 0 : departureAdress.hashCode());
		result = prime * result + ((destinationAdress == null) ? 0 : destinationAdress.hashCode());
		result = prime * result + (mealIncluded ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TransportType)) {
			return false;
		}
		TransportType other = (TransportType) obj;
		if (departureAdress == null) {
			if (other.departureAdress != null) {
				return false;
			}
		} else if (!departureAdress.equals(other.departureAdress)) {
			return false;
		}
		if (destinationAdress == null) {
			if (other.destinationAdress != null) {
				return false;
			}
		} else if (!destinationAdress.equals(other.destinationAdress)) {
			return false;
		}
		if (mealIncluded != other.mealIncluded) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return mealIncluded + ","+ departureAdress
				+ "," + destinationAdress;
	}
   
}
