package Test;

import java.util.Scanner; //To read input from the keyboard

import DAO_and_MVC.*; //Import DAO_and_MVC implementations

public class clientProgram { //Public class clientProgram to test the application
	
	public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) { //Creates a new Scanner instance to the input stream and this is passed as an argument
			int option = 2;
			if (option > 1) {
			    System.out.println("1 - List all countries in the database."); //Print all countries in the database
			    System.out.println("2 - Find a country by country code."); //Print a country by code
			    System.out.println("3 - Find a country by name."); //Print a country by name
			    System.out.println("4 - Save a new country in the database."); //Save a country into the database
			    System.out.println("5 - Exit."); //Exit the application
			    System.out.println("Please, choose your option."); //Print choose your option
			    option = teclado.nextInt(); //Method to read in a string of characters and converts them into an integer data type
			    while ((option > 0) & (option < 5)) { //While loop method used here to define parameters of the application
			    	countryController controller = new countryController(); //Create new countryController
			    	String code,name;
			        switch (option) {
			            case 1: //for option 1
			            	teclado.nextLine(); //This method returns the rest of the actual line
			            	controller.list_countrys(); //List countries
			                break; //Stop the application after that

			            case 2: //for option 2
			            	teclado.nextLine(); //This method returns the rest of the actual line
			            	System.out.println("Enter code"); //application will ask for the code
			            	code = teclado.nextLine(); //This method returns the rest of the current line
			            	while(code.length()>3) { //While method used in case that the user inserts more than 3 character code
			            		System.out.println("You must enter a 3 character code"); //Print instruction message
			            		code = teclado.nextLine(); //This method returns the rest of the actual line
			            	}
			            	controller.list_countrys_by_code(code); //List countries by code
			                break; //Stop the application after that

			            case 3: //for option 3
			            	teclado.nextLine(); //This method returns the rest of the actual line
			            	System.out.println("Enter name"); //application will ask for the name
			            	name = teclado.nextLine(); //This method returns the rest of the current line
			            	while(name.length()>52) { //While method used in case that the name length inserted by user is more than 52
			            		System.out.println("You must enter a 52 character name"); //Print instruction message
			            		name = teclado.nextLine(); //This method returns the rest of the actual line
			            	}
			            	controller.list_countrys_by_name(name); //List countries by name
			                break; //Stop the application after that

			            case 4: //for option 4
			            	String headofstate, surfacearea, continent; //Variable of type String
			            	continent continents = null; //Setting continents as null
			            	teclado.nextLine(); //This method returns the rest of the current line
			            	System.out.println("Enter code"); //application will ask for the code
			            	code = teclado.nextLine(); //This method returns the rest of the current line
			            	while(code.length()>3) { //While method used in case that the name length inserted by user is more than 3
			            		System.out.println("You must enter a 3 character code"); //Print instruction message
			            		code = teclado.nextLine(); //This method returns the rest of the actual line
			            	}
			            	
			            	System.out.println("Enter name"); //application will ask for the name
			            	name = teclado.nextLine(); //This method returns the rest of the current line
			            	while(name.length()>52) { //While method used in case that the name length inserted by user is more than 52
			            		System.out.println("You must enter a 52 character name"); //Print instruction message
			            		name = teclado.nextLine(); //This method returns the rest of the actual line
			            	}
			            	
			            	System.out.println("Enter headofstate"); //application will ask for the headofstate
			            	headofstate = teclado.nextLine(); //This method returns the rest of the current line
			            	while(name.length()>60) { //While method used in case that the name length inserted by user is more than 60
			            		System.out.println("You must enter a 60 character headofstate"); //Print instruction message
			            		name = teclado.nextLine(); //This method returns the rest of the actual line
			            	}
			            	
			            	System.out.println("Enter surfacearea"); //application will ask for the surfacearea
			            	surfacearea = teclado.nextLine(); //This method returns the rest of the current line
			            	
			                float new_surfacearea = Float.parseFloat(surfacearea); //String to be parsed
			                
			                System.out.println("Enter continent name"); //application will ask for the name
			                continent = teclado.nextLine(); //This method returns the rest of the actual line
			                
			                
			                switch(continent){
				                case "ASIA": //program will accept insertion in Caps Lock or Caps Down
				                case "asia": //program will accept insertion in Caps Lock or Caps Down
				                	continents = DAO_and_MVC.continent.ASIA; //Implementation of DAO_and_MVC
				                    break;// break line
				                case "EUROPE": //program will accept insertion in Caps Lock or Caps Down
				                case "europe": //program will accept insertion in Caps Lock or Caps Down
				                	continents = DAO_and_MVC.continent.EUROPE; //Implementation of DAO_and_MVC
				                    break;// break line
				                case "NORTH AMERICA": //program will accept insertion in Caps Lock or Caps Down
				                case "north america": //program will accept insertion in Caps Lock or Caps Down
				                	continents = DAO_and_MVC.continent.NORTH_AMERICA; //Implementation of DAO_and_MVC
				                    break; // break line
				                case "AFRICA":  //program will accept insertion in Caps Lock or Caps Down
				                case "africa":  //program will accept insertion in Caps Lock or Caps Down
				                	continents = DAO_and_MVC.continent.AFRICA; //Implementation of DAO_and_MVC
				                    break; // break line
				                case "OCEANIA": //program will accept insertion in Caps Lock or Caps Down
				                case "oceania": //program will accept insertion in Caps Lock or Caps Down
				                	continents = DAO_and_MVC.continent.OCEANIA; //Implementation of DAO_and_MVC
				                    break; // break line
				                case "ANTARCTICA": //program will accept insertion in Caps Lock or Caps Down
				                case "antarctica": //program will accept insertion in Caps Lock or Caps Down
				                	continents = DAO_and_MVC.continent.ANTARCTICA; //Implementation of DAO_and_MVC
				                    break; // break line
				                case "SOUTH_AMERICA": //program will accept insertion in Caps Lock or Caps Down
				                case "south america": //program will accept insertion in Caps Lock or Caps Down
				                	continents = DAO_and_MVC.continent.SOUTH_AMERICA; //Implementation of DAO_and_MVC
				                    break; // break line
				            }
			            	
			        		Country country = new Country(code, name, new_surfacearea, headofstate, continents); //Iniciatialization of country
			        		
			        		controller.register(country); //record country
			                break; // break line
			        }
			        System.out.println("1 - List all countries in the database."); //Print all countries in the database
			        System.out.println("2 - Find a country by country code."); //Find a country by code
			        System.out.println("3 - Find a country by name."); //Find a country by name
			        System.out.println("4 - Save a new country in the database."); //Print save a new country in the database
			        System.out.println("5 - Exit."); //Print exit
			        System.out.println("Please, choose your option."); //Print choose your option
			        option = teclado.nextInt(); //This method basically scans the next token of the input as an integer
			    }
			}else{
			    System.out.println("The database is connected by a singleton pattern, there is already an created instance."); //Else, return that the database is connected by a singleton pattern and created instance already exists
			}
		}
	}
}
