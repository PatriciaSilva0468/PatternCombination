package DAO_and_MVC;

import java.util.List;

public class viewCountry {
		
	public void list_countrys(List<Country> countrys) {
		for (Country country : countrys) {
			System.out.println("Code: "+country.getCode());
			System.out.println("Name: "+country.getName());
			System.out.println("Headofstate: "+country.getHeadofstate());
			System.out.println("Surfacearea: "+country.getSurfacearea());
			System.out.println("Continent: "+country.getContinent());
		}		
	}
	
	public void list_countrys_by_code(Country country) {
		System.out.println("Code: "+country.getCode());
		System.out.println("Name: "+country.getName());
		System.out.println("Headofstate: "+country.getHeadofstate());
		System.out.println("Surfacearea: "+country.getSurfacearea());
		System.out.println("Continent: "+country.getContinent());
	}
	
	public void list_countrys_by_name(Country country) {
		System.out.println("Code: "+country.getCode());
		System.out.println("Name: "+country.getName());
		System.out.println("Headofstate: "+country.getHeadofstate());
		System.out.println("Surfacearea: "+country.getSurfacearea());
		System.out.println("Continent: "+country.getContinent());
	}

}
