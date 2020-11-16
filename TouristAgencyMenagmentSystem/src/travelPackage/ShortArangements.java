package travelPackage;



public class ShortArangements {
         private double price;
         private String destination;
         
         public ShortArangements() {}

		public ShortArangements(double price, String destination) {
			super();
			this.price = price;
			this.destination = destination;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		@Override
		public String toString() {
			return price + "," + destination;
		}

		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof ShortArangements)) {
				return false;
			}
			ShortArangements other = (ShortArangements) obj;
			if (destination == null) {
				if (other.destination != null) {
					return false;
				}
			} else if (!destination.equals(other.destination)) {
				return false;
			}
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
				return false;
			}
			return true;
		}
         
}
