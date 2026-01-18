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
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField email;
	private JTextField password;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(200, 10, 54, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(51, 69, 74, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(51, 140, 74, 29);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(157, 73, 145, 23);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = username.getText();
				String mail = email.getText();
				String pass = password.getText();
				
				DBInsertion.insert(name, mail, pass);
				
		        JOptionPane.showMessageDialog(contentPane, "Login Successful!\nWelcome, " 
		        + name, "Success", 
		        JOptionPane.INFORMATION_MESSAGE);
		        
		        username.setText("");
		        email.setText("");
		        password.setText("");
			}
		});
		login.setFont(new Font("Times New Roman", Font.BOLD, 15));
		login.setBounds(157, 184, 84, 20);
		contentPane.add(login);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(51, 107, 74, 29);
		contentPane.add(lblNewLabel_2);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(157, 108, 145, 23);
		contentPane.add(email);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(157, 142, 145, 23);
		contentPane.add(password);

	}
}
