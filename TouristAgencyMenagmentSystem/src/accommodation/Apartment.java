package accommodation;

public class Apartment extends Accommodation {
	
	
	public Apartment(double square, int numberOfBeds, TypeOfBoard boardType, DestinationAdress adress) {
		super(square, numberOfBeds, boardType, adress);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getSquare() + "," + getNumberOfBeds() + "," + getBoardType()
				+ "," + getAdress();
	}

	public Apartment() {}

	public String uCSV() {
		return   getSquare() + "," + getNumberOfBeds() +","+ getBoardType() +"," +getAdress();
	}
}
