package DAO_and_MVC;

//This class its a model, country 
public class Country {
	
	private String code ; //Making the variable private for encapsulation
	private String name ; //Making the variable private for encapsulation
	private continent continent; //Making the variable private for encapsulation
	//Using float to store surfacearea
    private float surfacearea; //Making the variable private for encapsulation
    private String headofstate ; //Making the variable private for encapsulation
    
    //Constructor overloading setting parameter list
	public Country(String code, String name, float surfacearea, String headofstate, continent c) {
		super();
		
		//Initializing class fields for code, name, surfacearea, headofstate and continent
		this.code = code;
		this.name = name;
		this.surfacearea = surfacearea;
		this.headofstate = headofstate;
		this.continent = c;
	}
	
	//Use of getters and setters to access all class fields
	public String getCode() {
		return code;
	}
	
	//Use of getters and setters to access all class fields
	public void setCode(String code) {
		this.code = code;
	}
	
	//Use of getters and setters to access all class fields
	public String getName() {
		return name;
	}
	
	//Use of getters and setters to access all class fields
	public void setName(String name) {
		this.name = name;
	}
	
	//Use of getters and setters to access all class fields
	public float getSurfacearea() {
		return surfacearea;
	}
	
	//Use of getters and setters to access all class fields
	public void setSurfacearea(float surfacearea) {
		this.surfacearea = surfacearea;
	}
	
	//Use of getters and setters to access all class fields
	public String getHeadofstate() {
		return headofstate;
	}
	
	//Use of getters and setters to access all class fields
	public void setHeadofstate(String headofstate) {
		this.headofstate = headofstate;
	}

	//Use of getters and setters to access all class fields
	public continent getContinent() {
		return continent;
	}

	//Use of getters and setters to access all class fields
	public void setContinent(continent continent) {
		this.continent = continent;
	}
}

