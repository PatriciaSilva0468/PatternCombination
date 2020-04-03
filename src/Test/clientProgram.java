package Test;

import java.util.Scanner;

import DAO_and_MVC.*;

public class clientProgram {
	
	public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
			int option = 2;
			if (option > 1) {
			    System.out.println("1 - List all countries in the database.");
			    System.out.println("2 - Find a country by country code.");
			    System.out.println("3 - Find a country by name.");
			    System.out.println("4 - Save a new country in the database.");
			    System.out.println("5 - Exit.");
			    System.out.println("Please, choose your option.");
			    option = teclado.nextInt();
			    while ((option > 0) & (option < 5)) {
			    	countryController controller = new countryController();
			    	String code,name;
			        switch (option) {
			            case 1:
			            	teclado.nextLine();
			            	controller.list_countrys();
			                break;

			            case 2:
			            	teclado.nextLine();
			            	System.out.println("Enter code");
			            	code = teclado.nextLine();
			            	while(code.length()>3) {
			            		System.out.println("You must enter a 3 character code");
			            		code = teclado.nextLine();
			            	}
			            	controller.list_countrys_by_code(code);
			                break;

			            case 3:
			            	teclado.nextLine();
			            	System.out.println("Enter name");
			            	name = teclado.nextLine();
			            	while(name.length()>52) {
			            		System.out.println("You must enter a 52 character name");
			            		name = teclado.nextLine();
			            	}
			            	controller.list_countrys_by_name(name);
			                break;

			            case 4:
			            	String headofstate, surfacearea, continent;
			            	continent continents = null;
			            	teclado.nextLine();
			            	System.out.println("Enter code");
			            	code = teclado.nextLine();
			            	while(code.length()>3) {
			            		System.out.println("You must enter a 3 character code");
			            		code = teclado.nextLine();
			            	}
			            	
			            	System.out.println("Enter name");
			            	name = teclado.nextLine();
			            	while(name.length()>52) {
			            		System.out.println("You must enter a 52 character name");
			            		name = teclado.nextLine();
			            	}
			            	
			            	System.out.println("Enter headofstate");
			            	headofstate = teclado.nextLine();
			            	while(name.length()>60) {
			            		System.out.println("You must enter a 60 character headofstate");
			            		name = teclado.nextLine();
			            	}
			            	
			            	System.out.println("Enter surfacearea");
			            	surfacearea = teclado.nextLine();
			            	
			                float new_surfacearea = Float.parseFloat(surfacearea);
			                
			                System.out.println("Enter continent name");
			                continent = teclado.nextLine();
			                
			                
			                switch(continent){
				                case "ASIA":
				                case "asia":
				                	continents = DAO_and_MVC.continent.ASIA;
				                    break;
				                case "EUROPE":
				                case "europe":
				                	continents = DAO_and_MVC.continent.EUROPE;
				                    break;
				                case "NORTH AMERICA":
				                case "north america":
				                	continents = DAO_and_MVC.continent.NORTH_AMERICA;
				                    break;
				                case "AFRICA":
				                case "africa":
				                	continents = DAO_and_MVC.continent.AFRICA;
				                    break;
				                case "OCEANIA":
				                case "oceania":
				                	continents = DAO_and_MVC.continent.OCEANIA;
				                    break;
				                case "ANTARCTICA":
				                case "antarctica":
				                	continents = DAO_and_MVC.continent.ANTARCTICA;
				                    break;
				                case "SOUTH_AMERICA":
				                case "south america":
				                	continents = DAO_and_MVC.continent.SOUTH_AMERICA;
				                    break;
				            }
			            	
			        		Country country = new Country(code, name, new_surfacearea, headofstate, continents);
			        		
			        		controller.register(country);
			                break;
			        }
			        System.out.println("1 - List all countries in the database.");
			        System.out.println("2 - Find a country by country code.");
			        System.out.println("3 - Find a country by name.");
			        System.out.println("4 - Save a new country in the database.");
			        System.out.println("5 - Exit.");
			        System.out.println("Please, choose your option.");
			        option = teclado.nextInt();
			    }
			}else{
			    System.out.println("The database is connected by a singleton pattern, there is already an created instance.");
			}
		}
	}
}
