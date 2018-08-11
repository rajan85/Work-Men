package miniProject_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	private static Connection con ;
	static 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project_1", "root","root" );
		System.out.println("Connected!!!!!!!!!!!!!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("error----> problem in finding Driver class");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error---->  problem in connection");
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return con;
	}
}
