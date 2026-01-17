package Workshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DBInsertion {
	public static void insert(String name, String email, String pass) {
		String url ="jdbc:mysql://localhost/registration";
		String username = "root";
		String password = "";
		String query = "Insert into users"
				+"(username, email, password) values(?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstm = conn.prepareStatement(query);){
			pstm.setString(1, name);
			pstm.setString(2, email);
			pstm.setString(3, pass);
			pstm.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}