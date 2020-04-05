package DAO_and_MVC;
import java.util.List; //importing java.util library

//Interface for countryDAOimplement to use and create the methods there
public interface IcountryDAO {
	public boolean create(Country country); //Boolean method to create country
	public List<Country> list(); //Method to get a list of countries
	public Country list_by_code(String code); //Method to get a list of countries by code. Use variable of type String
	public Country list_by_name(String name); //Method to get a list of countries by name. Use variable of type String
}
