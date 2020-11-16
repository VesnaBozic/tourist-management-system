package agency;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import aplication.Menu;
import travelPackage.Arrangement;
import travelPackage.TravelPackage;

public class Agent extends User {
     private String idAgent;
     
     
     	public Agent () {}
	
        public Agent(String idAgent, String name, String surname, String userName, String code) {
		super(name, surname, userName, code);
		this.idAgent = idAgent;
	}

		
		
	

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!super.equals(obj)) {
				return false;
			}
			if (!(obj instanceof Agent)) {
				return false;
			}
			Agent other = (Agent) obj;
			if (idAgent == null) {
				if (other.idAgent != null) {
					return false;
				}
			} else if (!idAgent.equals(other.idAgent)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return idAgent +"," + getName() + "," + getSurname() +"," +getUserName() + "," + getCode();
		}

		public String getIdAgent() {
			return idAgent;
		}

		public void setIdAgent(String idAgent) {
			this.idAgent = idAgent;
		}

		public String uCSV() {
			return  idAgent +"," + getName() + "," + getSurname() +"," +getUserName() + "," + getCode();
		}
		
		public static void agentMenu(Agent loggedAgent) throws ParseException, IOException {
		try {	
			System.out.println("--------------------------------------------");
			System.out.println("Choose what you want to do:  :");
			System.out.println("--------------------------------------------");
			System.out.println("1. Create arrangement.");
			System.out.println("2. Create package.");
			System.out.println("3. Delete package. ");
			System.out.println("4. Log out.");
			System.out.println("--------------------------------------------");
			System.out.println("Enter number: ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch(choice) {
				
				case 1:
					Arrangement.creatingArrangement(loggedAgent);
				    break;
				case 2:
					TravelPackage.creatingPackageAgent(loggedAgent);
					break;
				case 3:
					TravelPackage.deletePackage(loggedAgent);
					break;
				case 4:
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
					    	 agentMenu(loggedAgent);
					 }
					 
					break;
				default:
					 System.out.println("--------------------------------------------");
			    	 System.out.println("Wrong entry");
			    	 System.out.println("Please, try again.");
			    	 System.out.println("--------------------------------------------");
			    	 agentMenu(loggedAgent);
					
			
			}}
		
		catch (InputMismatchException e) {
			System.out.println("--------------------------------------------");
			System.out.println("Wrong entry!");
			System.out.println("Please, try again.");
			System.out.println("--------------------------------------------");
			agentMenu(loggedAgent);
		}
		
			
			
		}

}
