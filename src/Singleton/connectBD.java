package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectBD {

	private static Connection conn = null;

    private connectBD(){
		String url = "jdbc:mysql://52.50.23.197:3306/world";
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "cctstudent";
		String password = "Pass1234!";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world", "cctstudent", "Pass1234!");
		}catch(ClassNotFoundException | SQLException e){
		    e.printStackTrace();
		}
    } 

    public static Connection getConnection(){
  
    	if (conn == null){
    		new connectBD();
    		System.out.println("success");
		}
  
		return conn;
    }
}
    