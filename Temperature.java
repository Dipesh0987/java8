package Workshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Temperature extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField celsius;
	private JTextField fahr;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperature frame = new Temperature();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Temperature() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Temperature Converter");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(140, 10, 180, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature in Celsius");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 54, 153, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Temperature in Fahrenheit");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(24, 152, 166, 21);
		contentPane.add(lblNewLabel_1_1);
		
		celsius = new JTextField();
		celsius.setBounds(232, 50, 118, 31);
		contentPane.add(celsius);
		celsius.setColumns(10);
		
		fahr = new JTextField();
		fahr.setColumns(10);
		fahr.setBounds(232, 148, 118, 31);
		contentPane.add(fahr);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						String celsiusTemp = celsius.getText();
						double cel = Double.parseDouble(celsiusTemp);
						double fahreinheit = (cel*9/5)+32;
						fahr.setText(String.valueOf(fahreinheit));
						}catch(Exception er) {
							fahr.setText("Error: "+er);
						}
					
				}catch(Exception er) {
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(236, 103, 98, 20);
		contentPane.add(btnNewButton);

	}

}
