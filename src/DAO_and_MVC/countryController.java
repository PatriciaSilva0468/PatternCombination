package DAO_and_MVC;

import java.util.ArrayList;
import java.util.List;

//Countrycontroller.java use clientProgram.java to create and list
public class countryController {
	
	private viewCountry vista= new viewCountry();
	
	public countryController() {
	}
	
	public void register(Country country) {
		IcountryDAO dao= new  countryDAOimplement();
		dao.create(country);
	}

	public void list_countrys(){
		List<Country> countrys = new ArrayList<Country>();
		IcountryDAO dao= new  countryDAOimplement();
		countrys=dao.list();
		vista.list_countrys(countrys);
	}
	
	public void list_countrys_by_code(String code){
		IcountryDAO dao = new  countryDAOimplement();
		Country country = dao.list_by_code(code);
		vista.list_countrys_by_code(country);
	}
	
	public void list_countrys_by_name(String name){
		IcountryDAO dao = new  countryDAOimplement();
		Country country = dao.list_by_name(name);
		vista.list_countrys_by_name(country);
	}
}
