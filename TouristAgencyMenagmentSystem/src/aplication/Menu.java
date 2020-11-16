package aplication;


import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;


import agency.Agent;
import agency.Client;




public class Menu {
	public static ArrayList<Agent> agents = new ArrayList<Agent>();
	public static ArrayList<Client> clients = new ArrayList<Client>();
		
	static Agent loggedAgent = new Agent();
	static Client loggedClient = new Client();
	

	static void readingAgent() {
		String agentID, agentName, agentSurname, agentUsername, agentPass;
		
		try 
		{
			
			File agentsCSV = new File("./data/agents.csv");
			
			FileReader fileReader = new FileReader(agentsCSV);
			BufferedReader buffer = new BufferedReader(fileReader);
			
			buffer.readLine();
			
			String emptyString = "";
			String[] emptyList;
		
			while ((emptyString = buffer.readLine()) != null) 
			{
				
				emptyList = emptyString.split(",");

				
				agentID = emptyList[0];
				agentName = emptyList[1];
				agentSurname = emptyList[2];
				agentUsername = emptyList[3];
				agentPass = emptyList[4];
				
				agents.add(new Agent(agentID, agentName, agentSurname, agentUsername,agentPass));
				
		
			
			}
			
		    fileReader.close();
			buffer.close();
			
		} 
		
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
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
			
		    fileReader.close();
			buffer.close();
			
		} 
		
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}

	
	}
	public static void mainMenu() throws IOException, ParseException {
	 

		
		
	readingAgent();
	readingClient();
	System.out.println("---------------------------------------------");
	System.out.println("************Welcome to Java Travel***********");
	System.out.println("---------------------------------------------");
	System.out.println("");
	System.out.println("Login as: ");
	System.out.println("--------------------------------------------");
	System.out.println("1. Agent");
	System.out.println("2. Client");
	System.out.println("3. Leave aplication!");
	
	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------");
		System.out.println("Your choice: ");
		System.out.println("--------------------------------------------");
		int choice = sc.nextInt();
	
	
	switch(choice) {
	case 1:
	Scanner sc1 = new Scanner(System.in);
	Scanner sce1 = new Scanner(System.in);
	System.out.println("--------------------------------------------");
	System.out.println("Enter your user name: ");
	System.out.println("--------------------------------------------");

	String userName = sc1.nextLine();
	System.out.println("--------------------------------------------");
	System.out.println("Enter your password: ");
	System.out.println("--------------------------------------------");
	String password = sce1.nextLine();
	boolean condition = false;
	
	for(Agent agent: agents) {
		if(agent.getUserName().equals(userName) & agent.getCode().equals(password)) {
			condition = true;
			loggedAgent.setIdAgent(agent.getIdAgent());
			loggedAgent.setName(agent.getName());
			loggedAgent.setSurname(agent.getSurname());
			loggedAgent.setUserName(agent.getUserName());
			loggedAgent.setCode(agent.getCode());
			
			Agent.agentMenu(loggedAgent);
		}
	}

	if(condition == false) {
		System.out.println("--------------------------------------------");
		System.out.println("Agent does not exist!");
		System.out.println("Please, try again.");
		System.out.println("--------------------------------------------");
	    mainMenu();}
			
	break;
	case 2:
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("--------------------------------------------");
		System.out.println("Enter your user name : ");
		System.out.println("--------------------------------------------");
		String clientUserName = sc2.nextLine();
		System.out.println("--------------------------------------------");
		System.out.println("Enter your password : ");
		System.out.println("--------------------------------------------");
		String passcode = sc2.nextLine();
		
		boolean condition2 = false;
		
		for(Client client: clients) {
			if(client.getUserName().equals(clientUserName) & client.getCode().equals(passcode)) {
				condition2 = true;
				loggedClient.setIdClient(client.getIdClient());
				loggedClient.setName(client.getName());
				loggedClient.setSurname(client.getSurname());
				loggedClient.setUserName(client.getUserName());
				loggedClient.setCode(client.getCode());
				loggedClient.setAvailableAmount(client.getAvailableAmount());
				
				Client.clientMenu(loggedClient);
			}
		}

        if(condition2 == false) {
        	System.out.println("--------------------------------------------");
        	System.out.println("Client does not exist!");
        	System.out.println("Please, try again.");
        	System.out.println("--------------------------------------------");
        	mainMenu();}
  			break;	
	 case 3:
		   System.out.println("****************************");
		   System.out.println("You left the aplication!");
		   System.out.println("Safe travels!");
		   System.out.println("****************************");
		   System.exit(0);
		   break;
     default:
    	 System.out.println("--------------------------------------------");
    	 System.out.println("Wrong entry");
    	 System.out.println("Please, try again.");
    	 System.out.println("--------------------------------------------");
    	 mainMenu();}}
    	
    catch(InputMismatchException e) {
    	System.out.println("--------------------------------------------");
    	System.out.println("Wrong entry!");
   	 	System.out.println("Please, try again.");
   	    System.out.println("--------------------------------------------");
    	mainMenu();
    	
    }
   
	
	
	
		
}}
