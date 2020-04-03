package DAO_and_MVC;
import java.util.List;

public interface IcountryDAO {
	public boolean create(Country country);
	public List<Country> list();
	public Country list_by_code(String code);
	public Country list_by_name(String name);
}
