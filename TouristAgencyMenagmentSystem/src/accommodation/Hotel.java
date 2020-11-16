package accommodation;

public class Hotel extends Accommodation {
	private int starsNumber;
	
	public Hotel() {}

	

	


	public Hotel(double square, int numberOfBeds, TypeOfBoard boardType, DestinationAdress adress, int starsNumber) {
		super(square, numberOfBeds, boardType, adress);
		this.starsNumber = starsNumber;
	}






	public int getStarsNumber() {
		return starsNumber;
	}

	public void setStarsNumber(int starsNumber) {
		this.starsNumber = starsNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + starsNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Hotel)) {
			return false;
		}
		Hotel other = (Hotel) obj;
		if (starsNumber != other.starsNumber) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getSquare() + "," + getNumberOfBeds() +","+ getBoardType() +"," +getAdress() +"," + starsNumber;
	}
	public String uCSV() {
		return   getSquare() + "," + getNumberOfBeds() +","+ getBoardType() +"," +getAdress() +","+ starsNumber ;
	
}
	
}
