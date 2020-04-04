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
		
		//Establishing a Connection to the database for insertation of code, name, surfacearea, headofstate and continent
		Statement stm= null;
		Connection con = connectBD.getConnection();
		String sql="INSERT INTO country (code,name,surfacearea,headofstate, continent) values ('"+country.getCode()+"','"+country.getName()+"','"+country.getSurfacearea()+"','"+country.getHeadofstate()+"','"+country.getContinent()+"')";

		//Try catch to create the connection and return true for registration then close the application otherwise return "Fail"
		try{
			stm= con.createStatement();
			stm.execute(sql);
			register=true;
			stm.close();
		}catch (SQLException e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
		//return the record if not previously in the database
		return register;
	}

	@Override
	
	//Method to list the countries
	public List<Country> list() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		//string sql to select the details from the database ordering by code
		String sql="SELECT * FROM country ORDER BY code";

		//Countries will be stored in an arraylist
		List<Country> listCountry= new ArrayList<Country>();
		
		//The try catch here is being implemented to test a block of code for errors during execution of the code
		//Application will connect with the database and create statement, after that sql query will be executed
		
		try {			
			co= connectBD.getConnection();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			String code, name, headofstate,continent;
        	float surfacearea ; 
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
	                	continents = DAO_and_MVC.continent.ASIA;
	                    break;
	                    
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "EUROPE":
	                	continents = DAO_and_MVC.continent.EUROPE;
	                    break;
	                    
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "NORTH_AMERICA":
	                	continents = DAO_and_MVC.continent.NORTH_AMERICA;
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "AFRICA":
	                	continents = DAO_and_MVC.continent.AFRICA;
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "OCEANIA":
	                	continents = DAO_and_MVC.continent.OCEANIA;
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "ANTARCTICA":
	                	continents = DAO_and_MVC.continent.ANTARCTICA;
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "SOUTH_AMERICA":
	                	continents = DAO_and_MVC.continent.SOUTH_AMERICA;
	                    break;
	                    //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	            }
				//Initializing country as setting default constructor values. This new country will be added to the list of country as c
				Country c= new Country(code,name,surfacearea,headofstate,continents);
				listCountry.add(c);
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Fail");
			
			//Return "Fail" if the application is not successful
			e.printStackTrace();
		}
		
		//Otherwise return the list of countries
		return listCountry;
	}

	@Override
	//Setting the parameters to create a public class which will search the countries by code
	public Country list_by_code(String code_to_search){
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		//String SQL to select the details from the database
		String sql="SELECT * FROM country WHERE code='"+code_to_search+"'";
		System.out.print(sql);
		
		//The try catch here is being implemented to test a block of code for errors during execution of the code
		//Application will connect with the database and create statement, after that sql query will be executed
		try {			
			co= connectBD.getConnection();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			String code, name, headofstate,continent;
        	float surfacearea ;
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
	                	continents = DAO_and_MVC.continent.ASIA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "EUROPE":
	                	continents = DAO_and_MVC.continent.EUROPE;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "NORTH_AMERICA":
	                	continents = DAO_and_MVC.continent.NORTH_AMERICA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "AFRICA":
	                	continents = DAO_and_MVC.continent.AFRICA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "OCEANIA":
	                	continents = DAO_and_MVC.continent.OCEANIA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "ANTARCTICA":
	                	continents = DAO_and_MVC.continent.ANTARCTICA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "SOUTH_AMERICA":
	                	continents = DAO_and_MVC.continent.SOUTH_AMERICA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	            }
				
				//Initializing country as setting default constructor values. This new country will return c
				Country c = new Country(code,name,surfacearea,headofstate, continents);
				return c;
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Fail");
		//Return "Fail" if the application is not successful
			e.printStackTrace();
		}
		return null;
	}

	@Override
	//Setting the parameters to create a public class which will search the countries by name
	public Country list_by_name(String name_to_search){
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		//String SQL to search for the specific country added into the database
		String sql="SELECT * FROM country WHERE name='"+name_to_search+"'";
		
		//The try catch here is being implemented to test a block of code for errors during execution of the code
		//Application will connect with the database and create statement, after that sql query will be executed
		try {			
			co= connectBD.getConnection();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			String code, name, headofstate, continent;
        	float surfacearea; 
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
	                	continents = DAO_and_MVC.continent.ASIA;
	                    break;
	              //break added to allow the application to break the actual flow of the program as it is going to a new continent after     
	                case "EUROPE":
	                	continents = DAO_and_MVC.continent.EUROPE;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "NORTH_AMERICA":
	                	continents = DAO_and_MVC.continent.NORTH_AMERICA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "AFRICA":
	                	continents = DAO_and_MVC.continent.AFRICA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "OCEANIA":
	                	continents = DAO_and_MVC.continent.OCEANIA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "ANTARCTICA":
	                	continents = DAO_and_MVC.continent.ANTARCTICA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	                case "SOUTH_AMERICA":
	                	continents = DAO_and_MVC.continent.SOUTH_AMERICA;
	                    break;
	                  //break added to allow the application to break the actual flow of the program as it is going to a new continent after
	            }
				
				//Initializing country as setting default constructor values. This new country will return c
				Country c = new Country(code,name,surfacearea,headofstate,continents);
				return c;
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Fail");
			//Return "Fail" if the application is not successful
			e.printStackTrace();
		}
		return null;
	}
}
