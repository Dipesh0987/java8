package Workshop;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginFetch extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtSearchName;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFetch frame = new LoginFetch();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginFetch() {
        setTitle("Search User from Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitle = new JLabel("Search User Data");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblTitle.setBounds(150, 10, 150, 30);
        contentPane.add(lblTitle);
        
        JLabel lblSearch = new JLabel("Enter Name:");
        lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblSearch.setBounds(50, 70, 100, 30);
        contentPane.add(lblSearch);
        
        txtSearchName = new JTextField();
        txtSearchName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtSearchName.setBounds(160, 70, 200, 30);
        contentPane.add(txtSearchName);
        txtSearchName.setColumns(10);
        
        JButton btnSearch = new JButton("Search User");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchUser();
            }
        });
        btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnSearch.setBounds(160, 120, 130, 35);
        contentPane.add(btnSearch);
        
        JButton btnBack = new JButton("Back to Login");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login loginFrame = new Login();
                loginFrame.setVisible(true);
                dispose();
            }
        });
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnBack.setBounds(160, 170, 130, 35);
        contentPane.add(btnBack);
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtSearchName.setText("");
            }
        });
        btnClear.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnClear.setBounds(160, 220, 130, 35);
        contentPane.add(btnClear);
    }
    
    /**
     * Method to search user in database and show in message box
     */
    private void searchUser() {
        String searchName = txtSearchName.getText().trim();
        
        // Check if name is entered
        if (searchName.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a name to search!", 
                "Input Required", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Database connection details - SAME AS YOUR DBFetch.java
        String url = "jdbc:mysql://localhost/registration";
        String dbUser = "root";
        String dbPassword = "";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // 1. Connect to database
            conn = DriverManager.getConnection(url, dbUser, dbPassword);
            
            // 2. Use EXACTLY THE SAME QUERY as DBFetch.java
            String query = "SELECT * FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, searchName);
            
            // 3. Execute query
            rs = pstmt.executeQuery();
            
            // 4. Check if user exists
            if (rs.next()) {
                // User found! Get the data
                String foundName = rs.getString("username");
                String foundEmail = rs.getString("email");
                String foundPassword = "********"; // Mask the password
                
                // Create a nice message box
                String message = 
                    "✅ USER FOUND SUCCESSFULLY!\n\n" +
                    "=== User Details ===\n\n" +
                    "Name: " + foundName + "\n" +
                    "Email: " + foundEmail + "\n" +
                    "Password: " + foundPassword + "\n\n" +
                    "=====================";
                
                // Show the message box
                JOptionPane.showMessageDialog(this, 
                    message, 
                    "User Found: " + foundName, 
                    JOptionPane.INFORMATION_MESSAGE);
                
                // Also call your DBFetch class to show in console
                DBFetch.fetchByName(searchName);
                
            } else {
                // User not found
                JOptionPane.showMessageDialog(this, 
                    "❌ USER NOT FOUND\n\n" +
                    "No user found with name: '" + searchName + "'\n" +
                    "Please check the name and try again.", 
                    "User Not Found", 
                    JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (SQLException e) {
            // Handle database errors
            String errorMessage = "";
            
            if (e.getMessage().contains("Table") && e.getMessage().contains("doesn't exist")) {
                errorMessage = "Table 'users' doesn't exist in database!";
            } else if (e.getMessage().contains("Unknown database")) {
                errorMessage = "Database 'registration' doesn't exist!";
            } else {
                errorMessage = e.getMessage();
            }
            
            JOptionPane.showMessageDialog(this, 
                "⚠️ DATABASE ERROR\n\n" +
                "Error: " + errorMessage + "\n\n" +
                "Please make sure:\n" +
                "1. MySQL is running\n" +
                "2. Database 'registration' exists\n" +
                "3. Table 'users' exists with columns: name, email, password", 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
            
        } finally {
            // Close database resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}