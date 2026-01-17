package Workshop;
import java.sql.*;

public class DBFetch {
	public static void fetchByName(String name) {
		String url = "jdbc:mysql://localhost/registration";
		String username = "root";
		String password = "";
		
		String query = "SELECT * FROM users WHERE name = ?";
		try (Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(query);){
			pstm.setString(1, name);
			ResultSet r = pstm.executeQuery();
			if (r.next()) {
				System.out.println("Pakadliya");
				System.out.println("Name: "+r.getString("name"));
				System.out.println("Email: "+r.getString("email"));
			}else {
				System.out.println("User not found");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
