// @author  Patricia Aparecida Da Silva (s2017146)
package DAO_and_MVC;

//importing java.util to be able to use the ArrayList
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Singleton.*;

//Public class countryDAOimplement implements IcountryDao interface
public class countryDAOimplement implements IcountryDAO {

	@Override
	//Boolean method to create country. If country is register, application should return false
	public boolean create(Country country) {
		boolean register = false;
		
		//Establishing a Connection to the database for insertion of code, name, surfacearea, headofstate and continent
		Statement stm= null; //Statement has been used to implement SQL statements with null parameters
		Connection con = connectBD.getConnection(); //Establishing Connection to the database
		//string sql used to insert data into the database
		String sql="INSERT INTO country (code,name,surfacearea,headofstate, continent) values ('"+country.getCode()+"','"+country.getName()+"','"+country.getSurfacearea()+"','"+country.getHeadofstate()+"','"+country.getContinent()+"')";

		//Try catch to create the connection and return true for registration then close the application otherwise return "Fail"
		try{
			stm= con.createStatement(); //Creating a statement
			stm.execute(sql); //To execute a query, the execute method was used
			register=true; //Returns true if the first object that the query returns is a ResultSet object
			stm.close(); //Method Statement.close used when we have finished to use a Statement 
		}catch (SQLException e) { //try catch method for sql exception
			System.out.println("Fail"); // System will print out fail if there is a problem
			e.printStackTrace(); /// print stack trace 
		}
		
		//return the record if not previously in the database
		return register;
	}

	@Override
	
	//Method to list the countries
	public List<Country> list() {
		Connection co =null; //Established connection
		Statement stm= null; // Setting statement to null
		ResultSet rs=null; // Result set will return null
		
		//string sql to select the details from the database ordering by code
		String sql="SELECT * FROM country ORDER BY code";

		//Countries will be stored in an arraylist
		List<Country> listCountry= new ArrayList<Country>();
		
		//The try catch here is being implemented to test a block of code for errors during execution of the code
		//Application will connect with the database and create statement, after that sql query will be executed
		
		try {			
			co= connectBD.getConnection(); //method to get connection
			stm=co.createStatement(); //creating statement
			rs=stm.executeQuery(sql); //Returns one ResultSet object
			String code, name, headofstate,continent; //Variable of type string
        	float surfacearea ; //float used to store surfacearea
        	continent continents = null; //continent equal to null
        	
        	//while sql statement is running to get code, name, headof state, surfacearea and continent
			while (rs.next()) {
				code = rs.getString(1);
				name = rs.getString(2);
				headofstate = rs.getString(3);
				surfacearea = rs.getFloat(4);
				continent = rs.getString(5); 
				switch(continent){
	                case "ASIA":
	                	continents = DAO_and_MVC.continent.ASIA; //DAO and MVC implementation
	                    break;
	                    
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "EUROPE":
	                	continents = DAO_and_MVC.continent.EUROPE; //DAO and MVC implementation
	                    break;
	                    
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "NORTH_AMERICA":
	                	continents = DAO_and_MVC.continent.NORTH_AMERICA; //DAO and MVC implementation
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "AFRICA":
	                	continents = DAO_and_MVC.continent.AFRICA; //DAO and MVC implementation
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "OCEANIA":
	                	continents = DAO_and_MVC.continent.OCEANIA; //DAO and MVC implementation
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "ANTARCTICA":
	                	continents = DAO_and_MVC.continent.ANTARCTICA; //DAO and MVC implementation
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "SOUTH_AMERICA":
	                	continents = DAO_and_MVC.continent.SOUTH_AMERICA; //DAO and MVC implementation
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	            }
				//Initializing country and setting default constructor values. This new country will be added to the list of country as c
				Country c= new Country(code,name,surfacearea,headofstate,continents);
				listCountry.add(c);
			}
			stm.close(); //Close statement
			rs.close(); //Close Resultset
		} catch (SQLException e) { //Try catch for sql exception
			System.out.println("Fail"); //System print out fail if there is a error
			
			//Return "Fail" if the application is not successful
			e.printStackTrace(); // print stack trace method
		}
		
		//Otherwise return the list of countries
		return listCountry;
	}

	@Override
	//Setting the parameters to create a public method which will search the countries by code
	public Country list_by_code(String code_to_search){
		Connection co =null; //Connection is equal to null
		Statement stm= null; //Setting statement to null
		ResultSet rs=null; //Result set equal to null
		
		//String SQL to select the details from the database
		String sql="SELECT * FROM country WHERE code='"+code_to_search+"'";
		System.out.print(sql);
		
		//The try catch here is being implemented to test a block of code for errors during execution of the code
		//Application will connect with the database and create statement, after that sql query will be executed
		try {			
			co= connectBD.getConnection(); //method to get connection
			stm=co.createStatement(); //creating statement
			rs=stm.executeQuery(sql); //Returns one ResultSet object
			String code, name, headofstate,continent; //Variable of type string
        	float surfacearea ; //float used to store surfacearea
        	continent continents = null; //continents set as null
        	
        	//while sql statement is running get code, name, headof state, surfacearea and continent
			while (rs.next()) {
				code = rs.getString(1);
				name = rs.getString(2);
				headofstate = rs.getString(3);
				surfacearea = rs.getFloat(4); 
				continent = rs.getString(5); 
				switch(continent){
	                case "ASIA":
	                	continents = DAO_and_MVC.continent.ASIA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "EUROPE":
	                	continents = DAO_and_MVC.continent.EUROPE; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "NORTH_AMERICA":
	                	continents = DAO_and_MVC.continent.NORTH_AMERICA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "AFRICA":
	                	continents = DAO_and_MVC.continent.AFRICA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "OCEANIA":
	                	continents = DAO_and_MVC.continent.OCEANIA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "ANTARCTICA":
	                	continents = DAO_and_MVC.continent.ANTARCTICA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "SOUTH_AMERICA":
	                	continents = DAO_and_MVC.continent.SOUTH_AMERICA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	            }
				
				//Initializing country as setting default constructor values. This new country will return c
				Country c = new Country(code,name,surfacearea,headofstate, continents);
				return c;
			}
			stm.close(); //Closing statement
			rs.close(); //Closing result set
		} catch (SQLException e) {
			System.out.println("Fail");
		//Return "Fail" if the application is not successful
			e.printStackTrace(); // print stack trace method
		}
		return null; //return null
	}

	@Override
	//Setting the parameters to create a public method which will search the countries by name
	public Country list_by_name(String name_to_search){
		Connection co =null; //Connection equal to null
		Statement stm= null; //Setting statement to null
		ResultSet rs=null; // Result set will return null
		
		//String SQL to search for the specific country added into the database
		String sql="SELECT * FROM country WHERE name='"+name_to_search+"'";
		
		//The try catch here is being implemented to test a block of code for errors during execution of the code
		//Application will connect with the database and create statement, after that sql query will be executed
		try {			
			co= connectBD.getConnection(); ////method to get connection
			stm=co.createStatement(); //creating statement
			rs=stm.executeQuery(sql); //Returns one ResultSet object
			String code, name, headofstate, continent; //Variable of type string
        	float surfacearea; //float used to store surfacearea
        	continent continents = null;
        	
        	//while sql statement is running get code, name, headof state, surfacearea and continent
			while (rs.next()) {
				code = rs.getString(1);
				name = rs.getString(2);
				headofstate = rs.getString(3);
				surfacearea = rs.getFloat(4); 
				continent = rs.getString(5); 
				switch(continent){
	                case "ASIA":
	                	continents = DAO_and_MVC.continent.ASIA; //DAO and MVC implementation
	                    break;
	              //break added to allow the application to break the actual flow of the program as it is going to a new continent after     
	                case "EUROPE":
	                	continents = DAO_and_MVC.continent.EUROPE; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "NORTH_AMERICA":
	                	continents = DAO_and_MVC.continent.NORTH_AMERICA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "AFRICA":
	                	continents = DAO_and_MVC.continent.AFRICA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "OCEANIA":
	                	continents = DAO_and_MVC.continent.OCEANIA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "ANTARCTICA":
	                	continents = DAO_and_MVC.continent.ANTARCTICA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "SOUTH_AMERICA":
	                	continents = DAO_and_MVC.continent.SOUTH_AMERICA; //DAO and MVC implementation
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	            }
				
				//Initializing country as setting default constructor values. This new country will return c
				Country c = new Country(code,name,surfacearea,headofstate,continents);
				return c;
			}
			stm.close(); //Closing statement
			rs.close(); //Closing result set
		} catch (SQLException e) {
			System.out.println("Fail");
			//Return "Fail" if the application is not successful
			e.printStackTrace(); // print stack trace method
		}
		return null; // return null
	}
}
