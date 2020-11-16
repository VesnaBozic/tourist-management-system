package agency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import aplication.Menu;
import travelPackage.TravelPackage;

public class Client extends User {
     private double availableAmount;
     private String idClient;
     
     public Client() {}

	
    public Client(String idClient,String name, String surname, String userName, String code, double availableAmount) {
		super(name, surname, userName, code);
		this.availableAmount = availableAmount;
		this.idClient = idClient;
	}


    public String toString() {
		return idClient + "," + getName() + "," + getSurname() +"," +"," + getUserName() + "," + getCode() + ","+availableAmount;
	}


    public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Client)) {
			return false;
		}
		Client other = (Client) obj;
		if (Double.doubleToLongBits(availableAmount) != Double.doubleToLongBits(other.availableAmount)) {
			return false;
		}
		if (idClient == null) {
			if (other.idClient != null) {
				return false;
			}
		} else if (!idClient.equals(other.idClient)) {
			return false;
		}
		return true;
	}


	public double getAvailableAmount() {
		return availableAmount;
	}


	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}


	public String getIdClient() {
		return idClient;
	}


	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}


	public String uCSV() {
		return idClient +"," + getName() + "," + getSurname() +"," +"," + getUserName() + "," + getCode() + ","+ availableAmount + "\n" ;
	}
	
	
	
	static String csvFile = "data/clients.csv";
	public static void saveClient(String first, String second, String third, String forth, String fifth,
			String sixth) {
		try {

			FileWriter fw = new FileWriter(csvFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "," + third + "," + forth + "," + fifth + "," + sixth);
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
			

		} catch (Exception E) {

		}
	}
	
	public static void del() {
		try {

			FileWriter fw = new FileWriter(csvFile, false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println("");
			pw.flush();
			pw.close();
			fw.close();
			bw.close();

		} catch (Exception E) {

		}
	}
	
	


	public static ArrayList<Client> clients = new ArrayList<Client>();
	
	static void readingClient() {
		String clientID, clientName, clientSurname, clientUsername, clientPass;
		double availableAmount;
		try 
		{
			
			File clientsCSV = new File("./data/clients.csv");
			
			FileReader fileReader = new FileReader(clientsCSV);
			BufferedReader buffer = new BufferedReader(fileReader);
			
			buffer.readLine();
			
			String emptyString = "";
			String[] emptyList;
			
			
			while ((emptyString = buffer.readLine()) != null) 
			{
				
				emptyList = emptyString.split(",");

				
				clientID = emptyList[0];
				clientName = emptyList[1];
				clientSurname = emptyList[2];
				clientUsername = emptyList[3];
				clientPass = emptyList[4];
				availableAmount = Double.parseDouble(emptyList[5]);
				
				clients.add(new Client(clientID, clientName, clientSurname, clientUsername,clientPass, availableAmount));
				
		     
			
			}
			
		
			buffer.close();
			
		} 
		
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}

	
	}
	
	public static void clientMenu(Client loggedClient) throws IOException, ParseException {
		clients.clear();
		readingClient();
	try {	
		System.out.println("Choose what you want to do:  :");
		System.out.println("--------------------------------------------");
		System.out.println("1. Deposit money.");
		System.out.println("2. Create package.");
		System.out.println("3. Buy package. ");
		System.out.println("4. Cancel package. ");
		System.out.println("5. Log out.");
		System.out.println("---------------------------------------------");
		System.out.println("Enter number: ");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice) {
			
		case 1:
		try {
			System.out.println("--------------------------------------------");
			System.out.println("You have " + loggedClient.getAvailableAmount() +"$ on your account.");
			System.out.println("--------------------------------------------");
			System.out.println("Please enter amount you want to deposit: ");
			System.out.println("--------------------------------------------");
			Scanner sc1 = new Scanner(System.in);
			double addAmount = sc1.nextDouble();
			double oldAmount =loggedClient.getAvailableAmount();
			loggedClient.setAvailableAmount(oldAmount + addAmount);
			System.out.println("--------------------------------------------");
			System.out.println("You succesfully deposited money!");
			System.out.println("--------------------------------------------");
			System.out.println("New amount on your account is: " + loggedClient.getAvailableAmount()+"$");
			System.out.println("--------------------------------------------");
			for(Client client: clients) {
				if(client.getUserName().equals(loggedClient.getUserName())) {
					
					client.setAvailableAmount(loggedClient.getAvailableAmount());
					del();
					
					
				}
			}
		    
			for(Client client: clients) {
				saveClient(client.idClient, client.getName(),client.getSurname(),client.getUserName(), client.getCode(), Double.toString(client.getAvailableAmount()));
			}
			
			
			
	
		
			Client.clientMenu(loggedClient);
			break;}
		catch (InputMismatchException e) {
			System.out.println("--------------------------------------------");
			System.out.println("Wrong entry!");
			System.out.println("Please, try again.");
			System.out.println("--------------------------------------------");
			Client.clientMenu(loggedClient);
		}

		
		case 2:
			//create package
			TravelPackage.creatingPackageClient(loggedClient);
			break;
		case 3:
			TravelPackage.buyPackage(loggedClient);
			//buy package
			break;
		case 4:
			//cancel package
			TravelPackage.cancelPackage(loggedClient);
			break;
		case 5:
			 System.out.println("--------------------------------------------");
			 System.out.println("Do you want to :");
			 System.out.println("1. Log out.");
			 System.out.println("2. Leave aplication.");
			 System.out.println("--------------------------------------------");
			 System.out.println("Enter number: ");
			 Scanner sc1 = new Scanner(System.in);
			 int l =sc1.nextInt();
			 switch(l) {
			    case 1:
			    	System.out.println("--------------------------------------------");
			    	System.out.println("You succesfully logged out.");
			    	System.out.println("--------------------------------------------");
			    	Menu.mainMenu();
			    	break;
			    case 2:
			    	System.out.println("*******************************");
					 System.out.println("You left the aplication!");
					 System.out.println("Safe travels!");
					 System.out.println("*******************************");
					 System.exit(0);
					break;
				default :
					 System.out.println("--------------------------------------------");
			    	 System.out.println("Wrong entry");
			    	 System.out.println("Please, try again.");
			    	 System.out.println("--------------------------------------------");
			    	 clientMenu(loggedClient);
			 }
			break;
		default:
			 System.out.println("--------------------------------------------");
	    	 System.out.println("Wrong entry");
	    	 System.out.println("Please, try again.");
	    	 System.out.println("--------------------------------------------");
	    	 clientMenu(loggedClient);
			
			
			
			
			
			
			
			
			
			
		}}
	catch (InputMismatchException e) {
		System.out.println("--------------------------------------------");
		System.out.println("Wrong entry!");
		System.out.println("Please, try again.");
		System.out.println("--------------------------------------------");
		clientMenu(loggedClient);
	}
	
	}
}
