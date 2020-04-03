package DAO_and_MVC;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Singleton.*;

public class countryDAOimplement implements IcountryDAO {

	@Override
	public boolean create(Country country) {
		boolean register = false;
		
		Statement stm= null;
		Connection con = connectBD.getConnection();
		String sql="INSERT INTO country (code,name,surfacearea,headofstate, continent) values ('"+country.getCode()+"','"+country.getName()+"','"+country.getSurfacearea()+"','"+country.getHeadofstate()+"','"+country.getContinent()+"')";

		try{
			stm= con.createStatement();
			stm.execute(sql);
			register=true;
			stm.close();
		}catch (SQLException e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
		return register;
	}

	@Override
	public List<Country> list() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM country ORDER BY code";

		List<Country> listCountry= new ArrayList<Country>();
		
		try {			
			co= connectBD.getConnection();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			String code, name, headofstate,continent;
        	float surfacearea ; 
        	continent continents = null;
        	
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
	                case "EUROPE":
	                	continents = DAO_and_MVC.continent.EUROPE;
	                    break;
	                case "NORTH_AMERICA":
	                	continents = DAO_and_MVC.continent.NORTH_AMERICA;
	                    break;
	                case "AFRICA":
	                	continents = DAO_and_MVC.continent.AFRICA;
	                    break;
	                case "OCEANIA":
	                	continents = DAO_and_MVC.continent.OCEANIA;
	                    break;
	                case "ANTARCTICA":
	                	continents = DAO_and_MVC.continent.ANTARCTICA;
	                    break;
	                case "SOUTH_AMERICA":
	                	continents = DAO_and_MVC.continent.SOUTH_AMERICA;
	                    break;
	            }
				Country c= new Country(code,name,surfacearea,headofstate,continents);
				listCountry.add(c);
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
		return listCountry;
	}

	@Override
	public Country list_by_code(String code_to_search){
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM country WHERE code='"+code_to_search+"'";
		System.out.print(sql);
		
		try {			
			co= connectBD.getConnection();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			String code, name, headofstate,continent;
        	float surfacearea ;
        	continent continents = null;
        	
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
	                case "EUROPE":
	                	continents = DAO_and_MVC.continent.EUROPE;
	                    break;
	                case "NORTH_AMERICA":
	                	continents = DAO_and_MVC.continent.NORTH_AMERICA;
	                    break;
	                case "AFRICA":
	                	continents = DAO_and_MVC.continent.AFRICA;
	                    break;
	                case "OCEANIA":
	                	continents = DAO_and_MVC.continent.OCEANIA;
	                    break;
	                case "ANTARCTICA":
	                	continents = DAO_and_MVC.continent.ANTARCTICA;
	                    break;
	                case "SOUTH_AMERICA":
	                	continents = DAO_and_MVC.continent.SOUTH_AMERICA;
	                    break;
	            }
				Country c = new Country(code,name,surfacearea,headofstate, continents);
				return c;
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Country list_by_name(String name_to_search){
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM country WHERE name='"+name_to_search+"'";
		
		try {			
			co= connectBD.getConnection();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			String code, name, headofstate, continent;
        	float surfacearea; 
        	continent continents = null;
        	
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
	                case "EUROPE":
	                	continents = DAO_and_MVC.continent.EUROPE;
	                    break;
	                case "NORTH_AMERICA":
	                	continents = DAO_and_MVC.continent.NORTH_AMERICA;
	                    break;
	                case "AFRICA":
	                	continents = DAO_and_MVC.continent.AFRICA;
	                    break;
	                case "OCEANIA":
	                	continents = DAO_and_MVC.continent.OCEANIA;
	                    break;
	                case "ANTARCTICA":
	                	continents = DAO_and_MVC.continent.ANTARCTICA;
	                    break;
	                case "SOUTH_AMERICA":
	                	continents = DAO_and_MVC.continent.SOUTH_AMERICA;
	                    break;
	            }
				Country c = new Country(code,name,surfacearea,headofstate,continents);
				return c;
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		return null;
	}
}
