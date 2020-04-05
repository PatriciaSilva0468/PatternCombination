package DAO_and_MVC;

import java.util.List; //import java.util library

public class viewCountry { //public class viewCountry
		
	public void list_countrys(List<Country> countrys) { //Method to get the list of countries
		for (Country country : countrys) {
			System.out.println("Code: "+country.getCode()); //Get method to print the code of the country
			System.out.println("Name: "+country.getName()); //Get method to print the name of the country
			System.out.println("Headofstate: "+country.getHeadofstate()); //Get method to print the Head of State of the country
			System.out.println("Surfacearea: "+country.getSurfacearea()); //Get method to print the Surfacearea of the country
			System.out.println("Continent: "+country.getContinent()); //Get method to print the continent in matter
		}		
	}
	
	public void list_countrys_by_code(Country country) { //Method to get the list of countries by code
		System.out.println("Code: "+country.getCode()); //Get method to print the code of the country
		System.out.println("Name: "+country.getName()); //Get method to print the name of the country
		System.out.println("Headofstate: "+country.getHeadofstate()); //Get method to print the Head of State of the country
		System.out.println("Surfacearea: "+country.getSurfacearea()); //Get method to print the Surfacearea of the country
		System.out.println("Continent: "+country.getContinent()); //Get method to print the continent in matter
	}
	
	public void list_countrys_by_name(Country country) { //Method to get the list of countries by name
		System.out.println("Code: "+country.getCode()); //Method to get the list of countries by code
		System.out.println("Name: "+country.getName()); //Get method to print the name of the country
		System.out.println("Headofstate: "+country.getHeadofstate()); //Get method to print the Head of State of the country
		System.out.println("Surfacearea: "+country.getSurfacearea()); //Get method to print the Surfacearea of the country
		System.out.println("Continent: "+country.getContinent()); //Get method to print the continent in matter
	}

}
