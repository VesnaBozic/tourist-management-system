package travelPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import accommodation.Accommodation;
import accommodation.Apartment;
import accommodation.City;
import accommodation.Country;
import accommodation.DepartureAdress;
import accommodation.DestinationAdress;
import accommodation.FlightClass;
import accommodation.Hotel;
import accommodation.Plane;
import accommodation.Train;
import accommodation.TrainClass;
import accommodation.TransportType;
import accommodation.TypeOfBoard;
import agency.Agent;

public class Arrangement {
	private double price;
	private boolean withInsurance;
	private boolean groupOrNot;
	private LocalDateTime departureDate;
	private LocalDateTime returnDate;
	private TransportType transport;
	private Accommodation accommodation;

	public Arrangement() {
	}

	
	public String toString() {
		return price + "," + withInsurance + "," + groupOrNot + "," + departureDate + "," + returnDate + "," + transport
				+ "," + accommodation;
	}


	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Arrangement)) {
			return false;
		}
		Arrangement other = (Arrangement) obj;
		if (accommodation == null) {
			if (other.accommodation != null) {
				return false;
			}
		} else if (!accommodation.equals(other.accommodation)) {
			return false;
		}
		if (departureDate == null) {
			if (other.departureDate != null) {
				return false;
			}
		} else if (!departureDate.equals(other.departureDate)) {
			return false;
		}
		if (groupOrNot != other.groupOrNot) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		if (returnDate == null) {
			if (other.returnDate != null) {
				return false;
			}
		} else if (!returnDate.equals(other.returnDate)) {
			return false;
		}
		if (transport == null) {
			if (other.transport != null) {
				return false;
			}
		} else if (!transport.equals(other.transport)) {
			return false;
		}
		if (withInsurance != other.withInsurance) {
			return false;
		}
		return true;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isWithInsurance() {
		return withInsurance;
	}

	public void setWithInsurance(boolean withInsurance) {
		this.withInsurance = withInsurance;
	}

	public boolean isGroupOrNot() {
		return groupOrNot;
	}

	public void setGroupOrNot(boolean groupOrNot) {
		this.groupOrNot = groupOrNot;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public TransportType getTransport() {
		return transport;
	}

	public void setTransport(TransportType transport) {
		this.transport = transport;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	public Arrangement(double price, boolean withInsurance, boolean groupOrNot, LocalDateTime departureDate,
			LocalDateTime returnDate, TransportType transport, Accommodation accommodation) {
		super();
		this.price = price;
		this.withInsurance = withInsurance;
		this.groupOrNot = groupOrNot;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.transport = transport;
		this.accommodation = accommodation;

	}

	public String uCSV() {
		return price + "," + withInsurance + "," + groupOrNot + "," + departureDate + "," + returnDate + "," + transport
				+ "," + accommodation;
	}

	static String csvFile = "data/arrangements.csv";

	public static void saveArrangement(String first, String second, String third, String forth, String fifth,
			String sixth, String seventh) {
		try {

			FileWriter fw = new FileWriter(csvFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "," + third + "," + forth + "," + fifth + "," + sixth + "," + seventh);
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
		

		} catch (Exception E) {

		}
	}

	static String csvFileC = "data/countries.csv";

	public static void saveCountry(String first, String second) {
		try {

			FileWriter fw = new FileWriter(csvFileC, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "\n");
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
			

		} catch (Exception E) {

		}

	}

	static String csvFileCity = "data/cities.csv";

	public static void saveCity(String first, String second) {
		try {

			FileWriter fw = new FileWriter(csvFileCity, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "\n");
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
			

		} catch (Exception E) {

		}

	}

	static String csvFileHotels = "data/hotels.csv";

	public static void saveHotel(String first, String second, String third, String forth, String fifth) {
		try {

			FileWriter fw = new FileWriter(csvFileHotels, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "," + third + "," + forth + "," + fifth + "\n");
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
		

		} catch (Exception E) {

		}

	}
	
	static String csvFileApartments = "data/apartments.csv";

	public static void saveApartment(String first, String second, String third, String forth) {
		try {

			FileWriter fw = new FileWriter(csvFileApartments, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "," + third + "," + forth + "\n");
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
		

		} catch (Exception E) {

		}

	}

	static String csvFileAdress = "data/destinationAdresses.csv";

	public static void saveDestAdress(String first, String second, String third) {
		try {

			FileWriter fw = new FileWriter(csvFileAdress, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "," + third + "\n");
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
			

		} catch (Exception E) {

		}
	}

	static String csvFileDadress = "data/departureAdresses.csv";

	public static void saveDepAdress(String first, String second, String third) {
		try {

			FileWriter fw = new FileWriter(csvFileDadress, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "," + third + "\n");
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
		

		} catch (Exception E) {

		}
	}

	static String csvFilePlanes = "data/planes.csv";

	public static void savePlane(String first, String second, String third, String forth) {
		try {

			FileWriter fw = new FileWriter(csvFilePlanes, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "," + third + "," + forth + "\n");
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
			

		} catch (Exception E) {

		}
	}

	static String csvFileTrains = "data/trains.csv";

	public static void saveTrain(String first, String second, String third, String forth) {
		try {

			FileWriter fw = new FileWriter(csvFileTrains, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "," + third + "," + forth + "\n");
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
		

		} catch (Exception E) {

		}
	}

	public static void creatingArrangement(Agent loggedAgent) throws DateTimeParseException, IOException, ParseException {
	
		Arrangement arrangement = new Arrangement();
		System.out.println("--------------------------------------------");
		System.out.println("To create new arrangement enter asked data: ");
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		Scanner sc0 = new Scanner(System.in);
		System.out.println("Enter price of arrangement: ");
		double priceAr = sc0.nextDouble();
		arrangement.setPrice(priceAr);

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("-----------------------------------------------------");
			System.out.println("Do you want insurance? ");
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.println("--------------------------------------------");
			System.out.println("Enter 1 or 2 : ");
			int insurance = sc.nextInt();
			if (insurance == 1) {
				arrangement.setWithInsurance(true);
			} else if (insurance == 2) {
				arrangement.setWithInsurance(false);
			} else {
				System.out.println("-------------------------------------------");
				System.out.println("Wrong entry");
				System.out.println("-------------------------------------------");

			}
		} catch (InputMismatchException e) {
			System.out.println("--------------------------------------------");
			System.out.println("Wrong entry!");
			System.out.println("Please, try again.");
			System.out.println("--------------------------------------------");
			creatingArrangement(loggedAgent);

		}
		System.out.println("--------------------------------------------");
		System.out.println("What kind of arrangement do yo want?");
		System.out.println("1. Group");
		System.out.println("2. Individual");
		System.out.println("--------------------------------------------");
		try {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter 1 or 2 : ");
			int group = sc1.nextInt();
			if (group == 1) {
				arrangement.setGroupOrNot(true);
			} else if (group == 2) {
				arrangement.setGroupOrNot(false);
			} else {
				System.out.println("-------------------------------------------");
				System.out.println("Wrong entry");
				System.out.println("-------------------------------------------");

			}
		} catch (InputMismatchException e) {
			System.out.println("--------------------------------------------");
			System.out.println("Wrong entry!");
			System.out.println("Please, try again.");
			System.out.println("--------------------------------------------");
			creatingArrangement(loggedAgent);

		}
		try {
			Scanner sc3 = new Scanner(System.in);
			System.out.println("--------------------------------------------");
			System.out.println("Enter departure time in form 2016-03-04 11:30: ");
			String departure = sc3.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(departure, formatter);
			arrangement.setDepartureDate(dateTime);
		} catch (DateTimeParseException e) {
			System.out.println("--------------------------------------------");
			System.out.println("This is not valid date! Try again!");
			System.out.println("--------------------------------------------");
			creatingArrangement(loggedAgent);
		}

		try {
			Scanner sc4 = new Scanner(System.in);
			System.out.println("--------------------------------------------");
			System.out.println("Enter return time in form 2016-03-04 11:30: ");
			String returnDate = sc4.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime1 = LocalDateTime.parse(returnDate, formatter);
			arrangement.setReturnDate(dateTime1);
		} catch (DateTimeParseException e) {
			System.out.println("--------------------------------------------");
			System.out.println("This is not valid date! Try again!");
			System.out.println("--------------------------------------------");
			creatingArrangement(loggedAgent);
		}
		System.out.println("--------------------------------------------");
		System.out.println("Choose accomodation : ");
		System.out.println("1. Hotel");
		System.out.println("2. Apartment");
		System.out.println("--------------------------------------------");
        try {
        	Scanner sc5 = new Scanner(System.in);
        	System.out.println("Enter 1 or 2 :");
        	int hotelOrApartment = sc5.nextInt();
        	switch(hotelOrApartment) {
        	case 1: //choosing hotel
        		//uslov novi hotel ili sa liste
        		Hotel hotel = new Hotel();
        		Scanner sc7 = new Scanner(System.in);
        		System.out.println("--------------------------------------------");
        		System.out.println("Enter square of room?");
        		Double square = sc7.nextDouble();
				hotel.setSquare(square);
				Scanner sc8 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Enter number of beds ?");
				int bedNumber = sc8.nextInt();
				hotel.setNumberOfBeds(bedNumber);
				Scanner sc9 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Choose type of board: ");
				System.out.println("1. Bed.");
				System.out.println("2. Bed and breakfast.");
				System.out.println("3. Half board.");
				System.out.println("4. Full board.");
				System.out.println("5. All inclusive.");
				System.out.println("--------------------------------------------");
				System.out.println("Enter number of your selection: ");
				int board = sc9.nextInt();
				switch (board) {
				case 1:
					hotel.setBoardType(TypeOfBoard.BED);
					break;
				case 2:
					hotel.setBoardType(TypeOfBoard.BED_AND_BREAKFAST);
					break;
				case 3:
					hotel.setBoardType(TypeOfBoard.HALF_BOARD);
					break;
				case 4:
					hotel.setBoardType(TypeOfBoard.FULL_BOARD);
					break;
				case 5:
					hotel.setBoardType(TypeOfBoard.ALL_INCLUSIVE);
					break;
				default:
					System.out.println("--------------------------------------------");
					System.out.println("Wrong entry. Please try again!");
					System.out.println("--------------------------------------------");
					creatingArrangement(loggedAgent);
				}
				System.out.println("--------------------------------------------");
				System.out.println("Please add hotel adress.");
				DestinationAdress adress = new DestinationAdress();
				Scanner sc10 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Add name of the street :");
				String street = sc10.nextLine();
				adress.setStreet(street);
				Scanner sc11 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Add street number: ");
				int streetNumber = sc11.nextInt();
				adress.setStreetNumber(streetNumber);
				System.out.println("--------------------------------------------");
				System.out.println("Add city.");
				City city = new City();
				Scanner sc13 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Enter name of the city : ");
				String cityName = sc13.nextLine();
				city.setCityName(cityName);
				Scanner sc14 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Enter name of the country: ");
				Country country = new Country();
				String countryName = sc14.nextLine();
				country.setCountryName(countryName);
				city.setCountry(country);
				country.setCities(new HashSet<City>());
				country.getCities().add(city);
				String firstCo = String.valueOf(country.getCountryName());
				String secondCo = String.valueOf(country.getCities());
				saveCountry(firstCo, secondCo);
				String firstC = String.valueOf(city.getCityName());
				String secondC = String.valueOf(city.getCountry());
				saveCity(firstC, secondC);
				adress.setCity(city);
				String firstA = String.valueOf(adress.getStreet());
				String secondA = String.valueOf(adress.getStreetNumber());
				String thirdA = String.valueOf(adress.getCity());
				saveDestAdress(firstA, secondA, thirdA);
				hotel.setAdress(adress);
				String firstH = String.valueOf(hotel.getSquare());
				String secondH = String.valueOf(hotel.getNumberOfBeds());
				String thirdH = String.valueOf(hotel.getBoardType());
				String forthH = String.valueOf(hotel.getAdress());
				Scanner sc15 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Enter number of stars: ");
				int stars = sc15.nextInt();
				hotel.setStarsNumber(stars);
				String fifthH = String.valueOf(hotel.getStarsNumber());

				saveHotel(firstH, secondH, thirdH, forthH, fifthH);
				System.out.println("--------------------------------------------");
				System.out.println("Choose type of transport: ");
				System.out.println("1. Plane");
				System.out.println("2. Train");
				System.out.println("--------------------------------------------");
				Scanner sc17 = new Scanner(System.in);
				System.out.println("Enter your choice: ");
				int planeOrTrain = sc17.nextInt();
				switch (planeOrTrain) {
				case 1: // plane
					System.out.println("--------------------------------------------");
					System.out.println("Add plane.");
					Plane plane = new Plane();

					try {
						Scanner sc20 = new Scanner(System.in);
						System.out.println("--------------------------------------------");
						System.out.println("Is meal included?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						System.out.println("--------------------------------------------");
						System.out.println("Enter your choice: ");
						int meal = sc20.nextInt();
						if (meal == 1) {
							plane.setMealIncluded(true);
						} else if (meal == 2) {
							plane.setMealIncluded(false);
						} else {
							System.out.println("-------------------------------------------");
							System.out.println("Wrong entry");
							System.out.println("-------------------------------------------");

						}
					} catch (InputMismatchException e) {
						System.out.println("--------------------------------------------");
						System.out.println("Wrong entry!");
						System.out.println("Please, try again.");
						System.out.println("--------------------------------------------");
						creatingArrangement(loggedAgent);

					}
					DepartureAdress departureAdress = new DepartureAdress();
					Scanner sc21 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Please add street of departure adress :");
					String da = sc21.nextLine();
					departureAdress.setStreet(da);
					System.out.println("--------------------------------------------");
					System.out.println("Please enter number of the street?");
					int sn = sc21.nextInt();
					departureAdress.setStreetNumber(sn);
					System.out.println("--------------------------------------------");
					System.out.println("Add city.");
					City city1 = new City();
					Scanner sc23 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Enter name of the city : ");
					String cityName1 = sc23.nextLine();
					city1.setCityName(cityName1);
					Scanner sc24 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Enter name of the country: ");
					Country country1 = new Country();
					String countryName1 = sc24.nextLine();
					country1.setCountryName(countryName1);
					city1.setCountry(country1);
					country1.setCities(new HashSet<City>());
					country1.getCities().add(city);
					String firstCon = String.valueOf(country1.getCountryName());
					String secondCon = String.valueOf(country1.getCities());
					saveCountry(firstCon, secondCon);
					String firstCont = String.valueOf(city.getCityName());
					String secondCont = String.valueOf(city.getCountry());
					saveCity(firstCont, secondCont);
					departureAdress.setCity(city1);
					String firstAd = String.valueOf(departureAdress.getStreet());
					String secondAd = String.valueOf(departureAdress.getStreetNumber());
					String thirdAd = String.valueOf(departureAdress.getCity());
					saveDepAdress(firstAd, secondAd, thirdAd);
					plane.setDepartureAdress(departureAdress);
					plane.setDestinationAdress(adress);
					System.out.println("--------------------------------------------");
					System.out.println("Please choose flight class: ");
					Scanner sc25 = new Scanner(System.in);
					System.out.println("1. Business class.");
					System.out.println("2. Economy class");
					System.out.println("--------------------------------------------");
					int choice = sc25.nextInt();
					switch (choice) {
					case 1:
						plane.setFlightClass(FlightClass.BUSINESS_CLASS);
						break;
					case 2:
						plane.setFlightClass(FlightClass.ECONOMY_CLASS);
						break;
					default:
						System.out.println("--------------------------------------------");
						System.out.println("Wrong choice. Please try again");
						System.out.println("--------------------------------------------");
						creatingArrangement(loggedAgent);
						break;
					}
					String firstP = String.valueOf(plane.isMealIncluded());
					String secondP = String.valueOf(plane.getDepartureAdress());
					String thirdP = String.valueOf(plane.getDestinationAdress());
					String forthP = String.valueOf(plane.getFlightClass());
					savePlane(firstP, secondP, thirdP, forthP);
					arrangement.setTransport(plane);
					arrangement.setAccommodation(hotel);
					String first = String.valueOf(arrangement.getPrice());
					String second = String.valueOf(arrangement.isWithInsurance());
					String third = String.valueOf(arrangement.isGroupOrNot());
					String forth = String.valueOf(arrangement.getDepartureDate());
					String fifth = String.valueOf(arrangement.getReturnDate());
					String sixth = String.valueOf(arrangement.getTransport());
					String seventh = String.valueOf(arrangement.getAccommodation());
					saveArrangement(first, second, third, forth, fifth, sixth, seventh);
					Agent.agentMenu(loggedAgent);
					break;
				case 2: //train
					System.out.println("--------------------------------------------");
					System.out.println("Add train");
					Train train = new Train();
					try {
						Scanner scenner = new Scanner(System.in);
						System.out.println("--------------------------------------------");
						System.out.println("Is meal included?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						System.out.println("--------------------------------------------");
						System.out.println("Enter your choice: ");
						int meal = scenner.nextInt();
						if (meal == 1) {
							train.setMealIncluded(true);
						} else if (meal == 2) {
							train.setMealIncluded(false);
						} else {
							System.out.println("-------------------------------------------");
							System.out.println("Wrong entry");
							System.out.println("-------------------------------------------");

						}
					} catch (InputMismatchException e) {
						System.out.println("--------------------------------------------");
						System.out.println("Wrong entry!");
						System.out.println("Please, try again.");
						System.out.println("--------------------------------------------");
						creatingArrangement(loggedAgent);

					}
					DepartureAdress departureAdressTrain = new DepartureAdress();
					Scanner scenner1 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Please add street of departure adress :");
					String daTrain = scenner1.nextLine();
					departureAdressTrain.setStreet(daTrain);
					System.out.println("--------------------------------------------");
					System.out.println("Please enter number of the street?");
					int snTrain = scenner1.nextInt();
					departureAdressTrain.setStreetNumber(snTrain);
					System.out.println("--------------------------------------------");
					System.out.println("Add city.");
					City city2 = new City();
					Scanner scenner3 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Enter name of the city : ");
					String cityName2 = scenner3.nextLine();
					city2.setCityName(cityName2);
					Scanner scenner4 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Enter name of the country: ");
					Country country2 = new Country();
					String countryName2 = scenner4.nextLine();
					country2.setCountryName(countryName2);
					city2.setCountry(country2);
					country2.setCities(new HashSet<City>());
					country2.getCities().add(city2);
					String firstCountry = String.valueOf(country2.getCountryName());
					String secondCountry = String.valueOf(country2.getCities());
					saveCountry(firstCountry, secondCountry);
					String firstCountry1 = String.valueOf(city2.getCityName());
					String secondCountry1 = String.valueOf(city2.getCountry());
					saveCity(firstCountry1, secondCountry1);
					departureAdressTrain.setCity(city2);
					String firstAdress = String.valueOf(departureAdressTrain.getStreet());
					String secondAdress = String.valueOf(departureAdressTrain.getStreetNumber());
					String thirdAdress = String.valueOf(departureAdressTrain.getCity());
					saveDepAdress(firstAdress, secondAdress, thirdAdress);
					train.setDepartureAdress(departureAdressTrain);
					train.setDestinationAdress(adress);
					System.out.println("--------------------------------------------");
					System.out.println("Please choose train class: ");
					Scanner scenner5 = new Scanner(System.in);
					System.out.println("1. First class.");
					System.out.println("2. Second class");
					System.out.println("2. Sleep car.");
					System.out.println("--------------------------------------------");
					int classTrain = scenner5.nextInt();
					switch (classTrain) {
					case 1:
						train.setTrainClass(TrainClass.FIRST_CLASS);
						break;
					case 2:
						train.setTrainClass(TrainClass.SECOND_CLASS);
						break;
					case 3:
						train.setTrainClass(TrainClass.SLEEP_CAR);
						break;
					default:
						System.out.println("--------------------------------------------");
						System.out.println("Wrong choice. Please try again");
						System.out.println("--------------------------------------------");
						creatingArrangement(loggedAgent);
						break;
					}
					String firstT = String.valueOf(train.isMealIncluded());
					String secondT = String.valueOf(train.getDepartureAdress());
					String thirdT = String.valueOf(train.getDestinationAdress());
					String forthT = String.valueOf(train.getTrainClass());
					saveTrain(firstT, secondT, thirdT, forthT);
					arrangement.setTransport(train);
					arrangement.setAccommodation(hotel);
					String first1 = String.valueOf(arrangement.getPrice());
					String second1 = String.valueOf(arrangement.isWithInsurance());
					String third1 = String.valueOf(arrangement.isGroupOrNot());
					String forth1 = String.valueOf(arrangement.getDepartureDate());
					String fifth1 = String.valueOf(arrangement.getReturnDate());
					String sixth1 = String.valueOf(arrangement.getTransport());
					String seventh1 = String.valueOf(arrangement.getAccommodation());
					saveArrangement(first1, second1, third1, forth1, fifth1, sixth1, seventh1);
					Agent.agentMenu(loggedAgent);
					try {
						Agent.agentMenu(loggedAgent);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				}
				break;
				
        	case 2: //chossing apartment	
        	
        		
        		Apartment apartment = new Apartment();
        		Scanner scenner8 = new Scanner(System.in);
        		System.out.println("--------------------------------------------");
        		System.out.println("Enter square of room?");
        		Double square1 = scenner8.nextDouble();
				apartment.setSquare(square1);
				Scanner scanner9 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Enter number of beds ?");
				int bedNumber1 = scanner9.nextInt();
				apartment.setNumberOfBeds(bedNumber1);
				Scanner scanner10 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Choose type of board: ");
				System.out.println("1. Bed.");
				System.out.println("2. Bed and breakfast.");
				System.out.println("3. Half board.");
				System.out.println("4. Full board.");
				System.out.println("5. All inclusive.");
				System.out.println("--------------------------------------------");
				System.out.println("Enter number of your selection: ");
				int board1 = scanner10.nextInt();
				switch (board1) {
				case 1:
					apartment.setBoardType(TypeOfBoard.BED);
					break;
				case 2:
					apartment.setBoardType(TypeOfBoard.BED_AND_BREAKFAST);
					break;
				case 3:
					apartment.setBoardType(TypeOfBoard.HALF_BOARD);
					break;
				case 4:
					apartment.setBoardType(TypeOfBoard.FULL_BOARD);
					break;
				case 5:
					apartment.setBoardType(TypeOfBoard.ALL_INCLUSIVE);
					break;
				default:
					System.out.println("--------------------------------------------");
					System.out.println("Wrong entry. Please try again!");
					System.out.println("--------------------------------------------");
					creatingArrangement(loggedAgent);
				}
				System.out.println("--------------------------------------------");
				System.out.println("Please add hotel adress.");
				DestinationAdress adress1 = new DestinationAdress();
				Scanner scanner12= new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Add name of the street :");
				String street1 = scanner12.nextLine();
				adress1.setStreet(street1);
				Scanner scanner13 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Add street number: ");
				int streetNumber1 = scanner13.nextInt();
				adress1.setStreetNumber(streetNumber1);
				System.out.println("--------------------------------------------");
				System.out.println("Add city.");
				City city1 = new City();
				Scanner scanner14 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Enter name of the city : ");
				String cityName1 = scanner14.nextLine();
				city1.setCityName(cityName1);
				Scanner scanner15 = new Scanner(System.in);
				System.out.println("--------------------------------------------");
				System.out.println("Enter name of the country: ");
				Country country1 = new Country();
				String countryName1 = scanner15.nextLine();
				country1.setCountryName(countryName1);
				city1.setCountry(country1);
				country1.setCities(new HashSet<City>());
				country1.getCities().add(city1);
				String firstCon = String.valueOf(country1.getCountryName());
				String secondCon = String.valueOf(country1.getCities());
				saveCountry(firstCon, secondCon);
				String firstCou = String.valueOf(city1.getCityName());
				String secondCou = String.valueOf(city1.getCountry());
				saveCity(firstCou, secondCou);
				adress1.setCity(city1);
				String firstAd = String.valueOf(adress1.getStreet());
				String secondAd = String.valueOf(adress1.getStreetNumber());
				String thirdAd = String.valueOf(adress1.getCity());
				saveDestAdress(firstAd, secondAd, thirdAd);
				apartment.setAdress(adress1);
				String firstAp = String.valueOf(apartment.getSquare());
				String secondAp = String.valueOf(apartment.getNumberOfBeds());
				String thirdAp = String.valueOf(apartment.getBoardType());
				String forthAp = String.valueOf(apartment.getAdress());
			

				saveApartment(firstAp, secondAp, thirdAp, forthAp);
				System.out.println("--------------------------------------------");
				System.out.println("Choose type of transport: ");
				System.out.println("1. Plane");
				System.out.println("2. Train");
				System.out.println("--------------------------------------------");
				Scanner scanner16 = new Scanner(System.in);
				
				System.out.println("Enter your choice: ");
				int planeOrTrain1 = scanner16.nextInt();
				switch (planeOrTrain1) {
				case 1: // plane
					System.out.println("--------------------------------------------");
					System.out.println("Add plane.");
					Plane plane = new Plane();

					try {
						Scanner sc20 = new Scanner(System.in);
						System.out.println("--------------------------------------------");
						System.out.println("Is meal included?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						System.out.println("Enter your choice: ");
						System.out.println("--------------------------------------------");
						int meal = sc20.nextInt();
						if (meal == 1) {
							plane.setMealIncluded(true);
						} else if (meal == 2) {
							plane.setMealIncluded(false);
						} else {
							System.out.println("-------------------------------------------");
							System.out.println("Wrong entry");
							System.out.println("-------------------------------------------");

						}
					} catch (InputMismatchException e) {
						System.out.println("--------------------------------------------");
						System.out.println("Wrong entry!");
						System.out.println("Please, try again.");
						System.out.println("--------------------------------------------");
						creatingArrangement(loggedAgent);

					}
					DepartureAdress departureAdress = new DepartureAdress();
					Scanner sc21 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Please add street of departure adress :");
					String da = sc21.nextLine();
					departureAdress.setStreet(da);
					System.out.println("--------------------------------------------");
					System.out.println("Please enter number of the street?");
					int sn = sc21.nextInt();
					departureAdress.setStreetNumber(sn);
					System.out.println("--------------------------------------------");
					System.out.println("Add city.");
					City city2 = new City();
					Scanner sc23 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Enter name of the city : ");
					String cityName2 = sc23.nextLine();
					city2.setCityName(cityName2);
					Scanner sc24 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Enter name of the country: ");
					Country country2 = new Country();
					String countryName2 = sc24.nextLine();
					country2.setCountryName(countryName2);
					city2.setCountry(country2);
					country2.setCities(new HashSet<City>());
					country2.getCities().add(city2);
					String firstCoun = String.valueOf(country2.getCountryName());
					String secondCoun = String.valueOf(country2.getCities());
					saveCountry(firstCoun, secondCoun);
					String firstCont = String.valueOf(city2.getCityName());
					String secondCont = String.valueOf(city2.getCountry());
					saveCity(firstCont, secondCont);
					departureAdress.setCity(city2);
					String firstAdr = String.valueOf(departureAdress.getStreet());
					String secondAdr = String.valueOf(departureAdress.getStreetNumber());
					String thirdAdr = String.valueOf(departureAdress.getCity());
					saveDepAdress(firstAdr, secondAdr, thirdAdr);
					plane.setDepartureAdress(departureAdress);
					plane.setDestinationAdress(adress1);
					System.out.println("--------------------------------------------");
					System.out.println("Please choose flight class: ");
					Scanner sc25 = new Scanner(System.in);
					System.out.println("1. Business class.");
					System.out.println("2. Economy class");
					System.out.println("--------------------------------------------");
					int choice = sc25.nextInt();
					switch (choice) {
					case 1:
						plane.setFlightClass(FlightClass.BUSINESS_CLASS);
						break;
					case 2:
						plane.setFlightClass(FlightClass.ECONOMY_CLASS);
						break;
					default:
						System.out.println("--------------------------------------------");
						System.out.println("Wrong choice. Please try again");
						System.out.println("--------------------------------------------");
						creatingArrangement(loggedAgent);
						break;
					}
					String firstP = String.valueOf(plane.isMealIncluded());
					String secondP = String.valueOf(plane.getDepartureAdress());
					String thirdP = String.valueOf(plane.getDestinationAdress());
					String forthP = String.valueOf(plane.getFlightClass());
					savePlane(firstP, secondP, thirdP, forthP);
					arrangement.setTransport(plane);
					arrangement.setAccommodation(apartment);
					String first = String.valueOf(arrangement.getPrice());
					String second = String.valueOf(arrangement.isWithInsurance());
					String third = String.valueOf(arrangement.isGroupOrNot());
					String forth = String.valueOf(arrangement.getDepartureDate());
					String fifth = String.valueOf(arrangement.getReturnDate());
					String sixth = String.valueOf(arrangement.getTransport());
					String seventh = String.valueOf(arrangement.getAccommodation());
					saveArrangement(first, second, third, forth, fifth, sixth, seventh);
					Agent.agentMenu(loggedAgent);
					break;
				case 2: //train
					System.out.println("--------------------------------------------");
					System.out.println("Add train");
					System.out.println("--------------------------------------------");
					Train train = new Train();
					try {
						Scanner scenner = new Scanner(System.in);
						System.out.println("--------------------------------------------");
						System.out.println("Is meal included?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						System.out.println("--------------------------------------------");
						System.out.println("Enter your choice: ");
						int meal = scenner.nextInt();
						if (meal == 1) {
							train.setMealIncluded(true);
						} else if (meal == 2) {
							train.setMealIncluded(false);
						} else {
							System.out.println("-------------------------------------------");
							System.out.println("Wrong entry");
							System.out.println("-------------------------------------------");

						}
					} catch (InputMismatchException e) {
						System.out.println("--------------------------------------------");
						System.out.println("Wrong entry!");
						System.out.println("Please, try again.");
						System.out.println("--------------------------------------------");
						creatingArrangement(loggedAgent);

					}
					DepartureAdress departureAdressTrain = new DepartureAdress();
					Scanner scenner1 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Please add street of departure adress :");
					String daTrain = scenner1.nextLine();
					departureAdressTrain.setStreet(daTrain);
					System.out.println("--------------------------------------------");
					System.out.println("Please enter number of the street?");
					int snTrain = scenner1.nextInt();
					departureAdressTrain.setStreetNumber(snTrain);
					System.out.println("--------------------------------------------");
					System.out.println("Add city.");
					City city3 = new City();
					Scanner scenner3 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Enter name of the city : ");
					String cityName3 = scenner3.nextLine();
					city3.setCityName(cityName3);
					Scanner scenner4 = new Scanner(System.in);
					System.out.println("--------------------------------------------");
					System.out.println("Enter name of the country: ");
					Country country3 = new Country();
					String countryName3 = scenner4.nextLine();
					country3.setCountryName(countryName3);
					city3.setCountry(country3);
					country3.setCities(new HashSet<City>());
					country3.getCities().add(city3);
					String firstCountry = String.valueOf(country3.getCountryName());
					String secondCountry = String.valueOf(country3.getCities());
					saveCountry(firstCountry, secondCountry);
					String firstCountry1 = String.valueOf(city3.getCityName());
					String secondCountry1 = String.valueOf(city3.getCountry());
					saveCity(firstCountry1, secondCountry1);
					departureAdressTrain.setCity(city3);
					String firstAdress = String.valueOf(departureAdressTrain.getStreet());
					String secondAdress = String.valueOf(departureAdressTrain.getStreetNumber());
					String thirdAdress = String.valueOf(departureAdressTrain.getCity());
					saveDepAdress(firstAdress, secondAdress, thirdAdress);
					train.setDepartureAdress(departureAdressTrain);
					train.setDestinationAdress(adress1);
					System.out.println("--------------------------------------------");
					System.out.println("Please choose flight class: ");
					Scanner scenner5 = new Scanner(System.in);
					System.out.println("1. Business class.");
					System.out.println("2. Economy class");
					System.out.println("--------------------------------------------");
					int classTrain = scenner5.nextInt();
					switch (classTrain) {
					case 1:
						train.setTrainClass(TrainClass.FIRST_CLASS);
						break;
					case 2:
						train.setTrainClass(TrainClass.SECOND_CLASS);
						break;
					case 3:
						train.setTrainClass(TrainClass.SLEEP_CAR);
						break;
					default:
						System.out.println("--------------------------------------------");
						System.out.println("Wrong choice. Please try again");
						System.out.println("--------------------------------------------");
						creatingArrangement(loggedAgent);
						break;
					}
					String firstT = String.valueOf(train.isMealIncluded());
					String secondT = String.valueOf(train.getDepartureAdress());
					String thirdT = String.valueOf(train.getDestinationAdress());
					String forthT = String.valueOf(train.getTrainClass());
					saveTrain(firstT, secondT, thirdT, forthT);
					arrangement.setTransport(train);
					arrangement.setAccommodation(apartment);
					String first1 = String.valueOf(arrangement.getPrice());
					String second1 = String.valueOf(arrangement.isWithInsurance());
					String third1 = String.valueOf(arrangement.isGroupOrNot());
					String forth1 = String.valueOf(arrangement.getDepartureDate());
					String fifth1 = String.valueOf(arrangement.getReturnDate());
					String sixth1 = String.valueOf(arrangement.getTransport());
					String seventh1 = String.valueOf(arrangement.getAccommodation());
					saveArrangement(first1, second1, third1, forth1, fifth1, sixth1, seventh1);
					Agent.agentMenu(loggedAgent);
					try {
						Agent.agentMenu(loggedAgent);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				}
				break;
        	}}
        
        	catch (InputMismatchException e) {
    			System.out.println("--------------------------------------------");
    			System.out.println("Wrong entry!");
    			System.out.println("Please, try again.");
    			System.out.println("--------------------------------------------");
    			creatingArrangement(loggedAgent);
    		}

		

	}

}
