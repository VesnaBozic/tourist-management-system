package accommodation;

public class Train extends TransportType {
	private TrainClass trainClass;
	
	public Train() {}

	@Override
	public String toString() {
		return isMealIncluded() + "," + getDepartureAdress() +","+ getDestinationAdress() +"," + trainClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((trainClass == null) ? 0 : trainClass.hashCode());
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
		if (!(obj instanceof Train)) {
			return false;
		}
		Train other = (Train) obj;
		if (trainClass != other.trainClass) {
			return false;
		}
		return true;
	}

	public TrainClass getTrainClass() {
		return trainClass;
	}

	public void setTrainClass(TrainClass trainClass) {
		this.trainClass = trainClass;
	}

	public Train(boolean mealIncluded, DepartureAdress departureAdress, DestinationAdress destinationAdress, TrainClass trainClass) {
		super(mealIncluded, departureAdress, destinationAdress);
		this.trainClass = trainClass;
	}
	
	public String uCSV() {
		return   isMealIncluded() + "," + getDepartureAdress() +","+ getDestinationAdress() +"," + trainClass;
	}
}

