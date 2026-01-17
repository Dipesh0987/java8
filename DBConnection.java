package Workshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost/registration";
		String username = "root";
		String password = "";
		try(Connection conn = DriverManager.getConnection(url, username, password);
				Statement stm = conn.createStatement();){
			System.out.println("Connection successful");
	//		stm.execute("CREATE DATABASE java_db");
//			stm.execute("CREATE TABLE students ("
//			          + "student_id VARCHAR(50) UNIQUE NOT NULL,"
//			          + "name VARCHAR(100) NOT NULL, "
//			          + "course VARCHAR(50) )");
			System.out.println("Table created");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}