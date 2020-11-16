package travelPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import agency.Agent;
import agency.Client;


public class TravelPackage implements Purchasable {
	private double rateOfReturn;
	public static ArrayList<ShortArangements> arrangements = new ArrayList<ShortArangements>();
	private String creator;
	private String client;
	
	public TravelPackage() {}

	public TravelPackage(double rateOfReturn, ArrayList<ShortArangements> arrangements, String creator, String client) {
		super();
		this.rateOfReturn = rateOfReturn;
		TravelPackage.arrangements = arrangements;
		this.creator= creator;
		this.client = client;
	}

	public double getRateOfReturn() {
		return rateOfReturn;
	}

	public void setRateOfReturn(double rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

	public Collection<ShortArangements> getArrangements() {
		return arrangements;
	}

	public void setArrangements(ArrayList<ShortArangements> arrangements) {
		TravelPackage.arrangements = arrangements;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String user) {
		this.creator = user;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TravelPackage)) {
			return false;
		}
		TravelPackage other = (TravelPackage) obj;
		if (arrangements == null) {
			if (TravelPackage.arrangements != null) {
				return false;
			}
		} else if (!arrangements.equals(TravelPackage.arrangements)) {
			return false;
		}
		if (client == null) {
			if (other.client != null) {
				return false;
			}
		} else if (!client.equals(other.client)) {
			return false;
		}
		if (Double.doubleToLongBits(rateOfReturn) != Double.doubleToLongBits(other.rateOfReturn)) {
			return false;
		}
		if (creator == null) {
			if (other.creator != null) {
				return false;
			}
		} else if (!creator.equals(other.creator)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return rateOfReturn +","+ arrangements + "," + creator
				+ "," + client;
	}
	public String uCSV() {
		return   rateOfReturn + "," + arrangements +","+ creator + "," + client ;
	}
	
	static String csvFile = "data/packages.csv";
	public static void savePackage(String first,String second,String third,String forth ,String fifth) {
		try {

			FileWriter fw = new FileWriter(csvFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first + "," + second + "," + third +"," + forth +","+ fifth );
			pw.flush();
			pw.close();
			fw.close();
			bw.close();
			
		} catch (Exception E) {

		}
	}
	
	public static void savePackage2(String first) {
		try {

			FileWriter fw = new FileWriter(csvFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(first);
			pw.flush();
			pw.close();
			fw.close();
			

		} catch (Exception E) {

		}
	}
	
  

	static void readingArr() {
		double price;
		String city;
		
		try 
		{
			
			File aCSV = new File("./data/arrangements.csv");
			
			FileReader fileReader = new FileReader(aCSV);
			BufferedReader buffer = new BufferedReader(fileReader);
			
			buffer.readLine();
			
			String emptyString = "";
			String[] emptyList;
		
			while ((emptyString = buffer.readLine()) != null) 
			{
				
				emptyList = emptyString.split(",");

				
				price= Double.parseDouble(emptyList[0]);
				city = emptyList[11];
				arrangements.add(new ShortArangements(price,city));
				
				
				
				
		
			
			}
			
		    
			buffer.close();
			
		} 
		
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}}

	public static void addArr() {
	
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Enter number of the arragement that you want to add to package: ");
		System.out.println("-----------------------------------------------------------------");
		int number1 = sc1.nextInt();
		int a1=0;
		ShortArangements shA1 = new ShortArangements();
		for(ShortArangements sa: arrangements) {
		a1++;
		if(number1 == a1) {
			shA1.setPrice(sa.getPrice());
			shA1.setDestination(sa.getDestination());
			packagePrice += shA1.getPrice();
			arrs.add(shA1);}}
		System.out.println("--------------------------------------------");
		System.out.println("Do you want to add more arrangements?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.println("--------------------------------------------");
		System.out.println("Enter your choice: ");
		Scanner sc3 = new Scanner(System.in);
		int b = sc3.nextInt();
		if(b==1) {
			addArr();
		}
	}
	
	
	static ArrayList<ShortArangements> arrs = new ArrayList<ShortArangements>();
	static double packagePrice = 0;
	public static void creatingPackageAgent(Agent loggedA) throws ParseException, IOException {
		arrs.clear();
		readingArr();
		packagePrice = 0;
		int arrsNum = 0;
		System.out.println("--------------------------------------------");
		System.out.println("Please choose arrangement for your package: ");
		String path = "data/arrangements.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			int i = 0;
			br.readLine();
			while ((line = br.readLine()) != null) {
				i++;
				System.out.println(i + "." + line);
				arrsNum++;
			} br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try {	
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------");
		System.out.println("Enter number of the arragement that you want to add to package: ");
		System.out.println("----------------------------------------------------------------");
		int number = sc.nextInt();
		int a=0;
		
		ShortArangements shA = new ShortArangements();
		for(ShortArangements sa: arrangements) {
		a++;
		if (number <= arrsNum) {
		if(number == a) {
			shA.setPrice(sa.getPrice());
			shA.setDestination(sa.getDestination());
			packagePrice += shA.getPrice();
			arrs.add(shA);
		}
		} else {
			System.out.println("--------------------------------------------");
			System.out.println("Wrong enter. Please try again.");
			System.out.println("--------------------------------------------");
			Agent.agentMenu(loggedA);
			break;
		}}
		
		
		    System.out.println("--------------------------------------------");
			System.out.println("Do you want to add more arrangements?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.println("--------------------------------------------");
			System.out.println("Enter your choice:");
			Scanner sc3 = new Scanner(System.in);
			int ba = sc3.nextInt();
			
			if (ba == 1) {
				addArr();
			}
			
		  
			
		
		System.out.println(arrs);
		System.out.println("--------------------------------------------");
		System.out.println("Enter rate of return: ");
		System.out.println("--------------------------------------------");
		Scanner sc2 = new Scanner(System.in);
		double rateOfReturn = sc2.nextDouble();
		
		savePackage(Double.toString(packagePrice),Double.toString(rateOfReturn),arrs.toString(),loggedA.getIdAgent(), "available" );
		
		Agent.agentMenu(loggedA);}
	catch (InputMismatchException e) {
		System.out.println("--------------------------------------------");
		System.out.println("Wrong entry!");
		System.out.println("Please, try again.");
		System.out.println("--------------------------------------------");
		creatingPackageAgent(loggedA);
	}

		
		
		
		
		}
	
	
	
	public static void del() {
		String csvFileP = "data/packages.csv";
		try {;
			
			FileWriter fw = new FileWriter(csvFileP, false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			PrintWriter pw = new PrintWriter(bw);
			pw.println();
			pw.flush();
			
			pw.close();
			fw.close();
			bw.close();

		} catch (Exception E) {
			System.out.println(E);

		}
	}

	static ArrayList<String> packs = new ArrayList<String>();
	static void readingPacks() {
		String package1;
	    
		
		try 
		{
			
			File pCSV = new File("./data/packages.csv");
			
			FileReader fileReader = new FileReader(pCSV);
			BufferedReader buffer = new BufferedReader(fileReader);
			
			buffer.readLine();
			
			String emptyString = "";
			String[] emptyList;
		
			while ((emptyString = buffer.readLine()) != null) 
			{
				
				emptyList = emptyString.split("\n");

				package1 = emptyList[0];
				
				
				
				packs.add(new String(package1));
			
				
		
			
			}
			
		    fileReader.close();
			buffer.close();
			
		} 
		
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}}
	public static void deletePackage(Agent loggedA) throws ParseException, IOException {
	packs.clear();
	readingPacks();	
	try {
		System.out.println("--------------------------------------------");
	System.out.println("Choose package that you want to delete: ");
	int packsNumber =0;
	String path = "data/packages.csv";
	try {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = "";
		int i = 0;
		br.readLine();
		while ((line = br.readLine()) != null) {
			i++;
			
			System.out.println(i + "." + line);
			packsNumber++;
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	System.out.println("----------------------------------------");
	System.out.println("Enter number of package :");
	Scanner sc2 = new Scanner(System.in);
	int choice = sc2.nextInt();
	int n = 0;
	for(String p: packs) {
		n++;
		if(choice<=packsNumber) {
		if(choice == n) {
			packs.remove(n-1);
			del();
			break;
		}} else {
			System.out.println("--------------------------------------------");
			System.out.println("Wrong enter. Please try again.");
			System.out.println("--------------------------------------------");
			Agent.agentMenu(loggedA);
			break;
		}
		
		
		

		
	}
	
	for (String p: packs) {
		if (p != null) {
			
	savePackage2(p);}}
	
	Agent.agentMenu(loggedA);}
	catch (InputMismatchException e) {
		System.out.println("--------------------------------------------");
		System.out.println("Wrong entry!");
		System.out.println("Please, try again.");
		System.out.println("--------------------------------------------");
		deletePackage(loggedA);
	}

	
	
	
	}
	
	public static void creatingPackageClient(Client loggedCl) throws ParseException, IOException {
		arrs.clear();
	    packagePrice= 0;
		readingArr();
		clients.clear();
		readingClient();
		int arrsNum =0;
		try {
		System.out.println("--------------------------------------------");
		System.out.println("Please choose arrangement for your package: ");
		String path = "data/arrangements.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			int i = 0;
			br.readLine();
			while ((line = br.readLine()) != null) {
				i++;
				System.out.println(i + "." + line);
				arrsNum++;
			} br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------");
		System.out.println("Enter number of the arragement that you want to add to package: ");
		System.out.println("----------------------------------------------------------------");
		int number = sc.nextInt();
		int a=0;
		
		ShortArangements shA = new ShortArangements();
		for(ShortArangements sa: arrangements) {
		a++;
		if (number <= arrsNum) {
		if(number == a) {
			shA.setPrice(sa.getPrice());
			shA.setDestination(sa.getDestination());
			packagePrice += shA.getPrice();
			arrs.add(shA);
			
		}}else {
			System.out.println("--------------------------------------------");
			System.out.println("Wrong enter. Please try again.");
			System.out.println("--------------------------------------------");
			Client.clientMenu(loggedCl);
			break;
			
		}
		}
		
		  
		System.out.println("--------------------------------------------");
			System.out.println("Do you want to add more arrangements?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.println("--------------------------------------------");
			System.out.println("Enter your choice: ");
			Scanner sc3 = new Scanner(System.in);
			int ba = sc3.nextInt();
			
			if (ba == 1) {
				addArr();
			}
			
			double oldAmount = loggedCl.getAvailableAmount();
			double returnMoney = oldAmount - packagePrice;
	    if(returnMoney>=0) {	
	   
			
			for(Client client: clients) {
				if(client.getUserName().equals(loggedCl.getUserName())) {
					loggedCl.setAvailableAmount(returnMoney);
					client.setAvailableAmount(returnMoney);
					delC();
					
					
				}
			}
			for(Client client: clients) {
				saveClient(client.getIdClient(), client.getName(),client.getSurname(),client.getUserName(), client.getCode(), Double.toString(client.getAvailableAmount()));
			}
		System.out.println(arrs);
		System.out.println("--------------------------------------------");
		System.out.println("Enter rate of return: ");
		System.out.println("--------------------------------------------");
		Scanner sc2 = new Scanner(System.in);
		double rateOfReturn = sc2.nextDouble();
		
		savePackage(Double.toString(packagePrice),Double.toString(rateOfReturn),arrs.toString(),loggedCl.getIdClient(), loggedCl.getIdClient() );
		
		Client.clientMenu(loggedCl);}
		   else {
		   System.out.println("-------------------------------------------------------------------------");
		   System.out.println("You don't have enough money to create this package! Please deposit money.");
		   System.out.println("-------------------------------------------------------------------------");
		   Client.clientMenu(loggedCl);}}
		
		catch (InputMismatchException e) {
			System.out.println("--------------------------------------------");
			System.out.println("Wrong entry!");
			System.out.println("Please, try again.");
			System.out.println("--------------------------------------------");
			creatingPackageClient(loggedCl);
		}
		
		
		
		
		}
	public static ArrayList<Client> clients = new ArrayList<Client>();
	static String csvFileC = "data/clients.csv";
	public static void delC() {
		try {

			FileWriter fw = new FileWriter(csvFileC, false);
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
	public static void saveClient(String first, String second, String third, String forth, String fifth,
			String sixth) {
		try {

			FileWriter fw = new FileWriter(csvFileC, true);
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
	
	public static void buyPackage(Client loggedClient) throws IOException, ParseException {
		packs.clear();
		readingPacks();
		clients.clear();
		readingClient();
		
		
		System.out.println("--------------------------------------------");
		System.out.println("These packages are available: ");
		System.out.println("--------------------------------------------");
		
		String path = "data/packages.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			int i = 0;
			br.readLine();
			while ((line = br.readLine()) != null) {
				i++;
				if(line.contains("available")) {
				System.out.println(i + "." + line);
				}
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		System.out.println("----------------------------------------------------");
		System.out.println("Enter number of the package that you want to buy: ");
		System.out.println("----------------------------------------------------");
		Scanner sc3 = new Scanner(System.in);
		int choice1 = sc3.nextInt();
		int n = 0;
		for(String p: packs) {
			n++;
			 {
				
			if(choice1 == n) {
				String[] a = p.split(",");
				ArrayList<String> a1 = new ArrayList<String>();
				int k=0;
				for(int o =0; o<a.length; o++) {
					k++;
					a1.add(a[o]);
				
				}
				double oldAmount =loggedClient.getAvailableAmount();
				oldAmount -= Double.parseDouble(a[0]);
				if(oldAmount >= 0) {
				
				for(Client client: clients) {
					if(client.getUserName().equals(loggedClient.getUserName())) {
						loggedClient.setAvailableAmount(oldAmount);
						client.setAvailableAmount(oldAmount);
						delC();
						
						
					}
				}} else {
					System.out.println("--------------------------------------------------");
					System.out.println("You don't have enough money. Please deposit money!");
				    System.out.println("--------------------------------------------------");
					Client.clientMenu(loggedClient);
					break;
				}
				for(Client client: clients) {
					saveClient(client.getIdClient(), client.getName(),client.getSurname(),client.getUserName(), client.getCode(), Double.toString(client.getAvailableAmount()));
				    
				}
				a1.remove(k-1);
				a1.add(loggedClient.getIdClient());
				
				
				
				packs.remove(n-1);
				packs.add(a1.toString().replace("[","").trim().replace("]","").trim());
				
				del();
				break;
			}
			}
			
			
			

			
		}
		
		for (String p: packs) {
			if (p != null) {
				
		savePackage2(p.replace(" ",""));}}
		
		Client.clientMenu(loggedClient);}
		catch (InputMismatchException e) {
			System.out.println("--------------------------------------------");
			System.out.println("Wrong entry!");
			System.out.println("Please, try again.");
			System.out.println("--------------------------------------------");
			buyPackage(loggedClient);
		}
		
		
	}
	
	public static void cancelPackage(Client loggedClient) throws IOException, ParseException {
		packs.clear();
		readingPacks();
		clients.clear();
		readingClient();
		int packsNum =0;
		System.out.println("--------------------------------------------");
		System.out.println("These are yours packages: ");
		System.out.println("--------------------------------------------");
		
		String path = "data/packages.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			int i = 0;
			br.readLine();
			while ((line = br.readLine()) != null) {
				i++;
				if(line.contains(loggedClient.getIdClient())) {
				System.out.println(i + "." + line);}
				packsNum++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		System.out.println("----------------------------------------");
		System.out.println("Enter number of package :");
		Scanner sc2 = new Scanner(System.in);
		int choice = sc2.nextInt();
		int n = 0;
		for(String p: packs) {
			n++;
			if(choice <= packsNum) {
			if(choice == n) {
				String[] a = p.split(",");
				ArrayList<String> a1 = new ArrayList<String>();
				int k = 0;
				for(int o=0; o<a.length; o++) {
					k++;
					a1.add(a[o]);
				}
				double oldAmount = loggedClient.getAvailableAmount();
				double returnMoney = (Double.parseDouble(a[0]) * Double.parseDouble(a[1]))/100;
				oldAmount += returnMoney;
				for(Client client: clients) {
					if(client.getUserName().equals(loggedClient.getUserName())) {
						loggedClient.setAvailableAmount(oldAmount);
						client.setAvailableAmount(oldAmount);
						delC();
						
						
					}
				}
				for(Client client: clients) {
					saveClient(client.getIdClient(), client.getName(),client.getSurname(),client.getUserName(), client.getCode(), Double.toString(client.getAvailableAmount()));
				}
			
				a1.remove(k-1);
				a1.add("available");
				packs.remove(n-1);
				
				packs.add(a1.toString().replace("[","").replace("]",""));
				del();
				break;
			}} else {
				System.out.println("--------------------------------------------");
				System.out.println("Wrong enter. Please try again.");
				System.out.println("--------------------------------------------");
				Client.clientMenu(loggedClient);
				break;
			}
			
			
			

			
		}
		
		for (String p: packs) {
			if (p != null) {
				
		savePackage2(p.replace(" ", ""));}}
		
		Client.clientMenu(loggedClient);
		
		
	}	catch (InputMismatchException e) {
		System.out.println("--------------------------------------------");
		System.out.println("Wrong entry!");
		System.out.println("Please, try again.");
		System.out.println("--------------------------------------------");
		buyPackage(loggedClient);
	}
	
		
	}
	
	
	
	
	
	
}
