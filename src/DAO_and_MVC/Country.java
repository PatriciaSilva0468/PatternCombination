package DAO_and_MVC;

// this class its a model, country 
public class Country {
	
	private String code ;
	private String name ;
	private continent continent;
    private float surfacearea;
    private String headofstate ;
    
	public Country(String code, String name, float surfacearea, String headofstate, continent c) {
		super();
		this.code = code;
		this.name = name;
		this.surfacearea = surfacearea;
		this.headofstate = headofstate;
		this.continent = c;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getSurfacearea() {
		return surfacearea;
	}
	
	public void setSurfacearea(float surfacearea) {
		this.surfacearea = surfacearea;
	}
	
	public String getHeadofstate() {
		return headofstate;
	}
	
	public void setHeadofstate(String headofstate) {
		this.headofstate = headofstate;
	}

	public continent getContinent() {
		return continent;
	}

	public void setContinent(continent continent) {
		this.continent = continent;
	}
}

