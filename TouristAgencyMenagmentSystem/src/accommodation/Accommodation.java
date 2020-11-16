package accommodation;

public abstract class Accommodation {
	private double square;
	private int numberOfBeds;
	private TypeOfBoard boardType;
	private DestinationAdress adress;
	
	public Accommodation() {}

	@Override
	public String toString() {
		return square + "," + numberOfBeds + "," + boardType
				+ "," + adress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((boardType == null) ? 0 : boardType.hashCode());
		result = prime * result + numberOfBeds;
		long temp;
		temp = Double.doubleToLongBits(square);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Accommodation)) {
			return false;
		}
		Accommodation other = (Accommodation) obj;
		if (adress == null) {
			if (other.adress != null) {
				return false;
			}
		} else if (!adress.equals(other.adress)) {
			return false;
		}
		if (boardType != other.boardType) {
			return false;
		}
		if (numberOfBeds != other.numberOfBeds) {
			return false;
		}
		if (Double.doubleToLongBits(square) != Double.doubleToLongBits(other.square)) {
			return false;
		}
		return true;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public TypeOfBoard getBoardType() {
		return boardType;
	}

	public void setBoardType(TypeOfBoard boardType) {
		this.boardType = boardType;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(DestinationAdress adress) {
		this.adress = adress;
	}

	public Accommodation(double square, int numberOfBeds, TypeOfBoard boardType, DestinationAdress adress) {
		super();
		this.square = square;
		this.numberOfBeds = numberOfBeds;
		this.boardType = boardType;
		this.adress = adress;
	}
}
