package DAO_and_MVC;

//Importing java.util library for the use of ArrayList
import java.util.ArrayList;
import java.util.List;

//Countrycontroller.java use clientProgram.java to create and list
//countryControler is used here to deal with requests for the country entity

public class countryController { //public class countryController
	
	private viewCountry vista= new viewCountry(); //Creating an object for the class called vista which will store the countries
	
	public countryController() { //Default constructor
	}
	
	public void register(Country country) {
		IcountryDAO dao= new  countryDAOimplement(); //Creating an object to provides access to the database or any other storage
		dao.create(country); //Creating the object itself
	}

	public void list_countrys(){ //list_country method
		List<Country> countrys = new ArrayList<Country>(); //Array List is used here to store the list of countries
		IcountryDAO dao= new  countryDAOimplement(); //Implementation of the DAO object to store the country
		countrys=dao.list(); //Countries will be presented in the DAO list
		vista.list_countrys(countrys); //method return the list of countries
	}
	
	public void list_countrys_by_code(String code){ //list_country_by_code method that passes a String code as parameter
		IcountryDAO dao = new  countryDAOimplement(); //Implementation of the DAO object to store the country
		Country country = dao.list_by_code(code); //Implementation of the DAO object to store the list of countries by code
		vista.list_countrys_by_code(country); //method return the list of countries by code
	}
	
	public void list_countrys_by_name(String name){ //list_country_by_name method that passes a String name as parameter
		IcountryDAO dao = new  countryDAOimplement(); //Implementation of the DAO object to store the country
		Country country = dao.list_by_name(name); //Implementation of the DAO object to store the list of countries by name
		vista.list_countrys_by_name(country); //method return the list of countries by name
	}
}
