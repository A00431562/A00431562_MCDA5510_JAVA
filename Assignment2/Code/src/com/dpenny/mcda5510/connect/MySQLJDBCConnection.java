package com.dpenny.mcda5510.connect;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLJDBCConnection implements DBConnection{

	public Connection setupConnection()  {

		Connection connection = null;
		try {
			// This will load the MySQL driver, each DB has its own driver
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			// Setup the connection with the DB
			connection = DriverManager.getConnection("jdbc:mysql://localhost/transactions?" + "user=sid&password=training34" // Url + Credentials provided
					+ "&useSSL=false" // b/c localhost
					+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); // timezone

		} catch (Exception e) {
			System.out.println("Error setting up in connection!");
			e.printStackTrace();
		} finally {

		}
		System.out.println("Connection established successfully!!");
		return connection;
	}		
	
	
}
