package Singleton;

import java.sql.Connection; //Importing java.sql connection for connection with the lecturer database
import java.sql.DriverManager; //JDBC drivers
import java.sql.SQLException; //Importing java.sql exception to handle errors with the database

public class connectBD { //Public class connectBD

	private static Connection conn = null; //Private static connection initializer

    private connectBD(){
		String url = "jdbc:mysql://52.50.23.197:3306/world"; //Defining path to the database
		String driver = "com.mysql.cj.jdbc.Driver"; //JDBC Driver path
		String user = "cctstudent"; //Username of the database in Workbench
		String password = "Pass1234!"; //Password of the database in Workbench
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver"); //Returns the class object
		    conn = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world", "cctstudent", "Pass1234!"); //Establishing connection with the database
		}catch(ClassNotFoundException | SQLException e){ //Try catch method to handle exceptions
		    e.printStackTrace(); //print stack trace method
		}
    } 

    public static Connection getConnection(){ //Method to getConnection
  
    	if (conn == null){ //If connection is equal to null create new connection with the database
    		new connectBD(); //If connection is equal to null create new connection with the database
    		System.out.println("success"); //if application is connect with the database print success
		}
  
		return conn; //otherwise return connection
    }
}
    