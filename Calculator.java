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

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField num1;
	private JTextField num2;
	private JTextField result;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculator");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(179, 10, 102, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFirstNumber.setBounds(48, 62, 102, 30);
		contentPane.add(lblFirstNumber);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSecondNumber.setBounds(48, 101, 102, 30);
		contentPane.add(lblSecondNumber);
		
		num1 = new JTextField();
		num1.setBounds(179, 69, 102, 19);
		contentPane.add(num1);
		num1.setColumns(10);
		
		num2 = new JTextField();
		num2.setColumns(10);
		num2.setBounds(179, 108, 102, 19);
		contentPane.add(num2);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String firstNum = num1.getText();
				String secondNum = num2.getText();
				double Num1 = Double.parseDouble(firstNum);
				double Num2 = Double.parseDouble(secondNum);
				double sum = Num1 + Num2;
				result.setText(String.valueOf(sum));
				}catch(Exception er) {
					result.setText("Error: "+er);
				}
			}
		});
		add.setBounds(48, 163, 84, 20);
		contentPane.add(add);
		
		JButton subtract = new JButton("Subtract");
		subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String firstNum = num1.getText();
				String secondNum = num2.getText();
				double Num1 = Double.parseDouble(firstNum);
				double Num2 = Double.parseDouble(secondNum);
				double sum = Num1 - Num2;
				result.setText(String.valueOf(sum));
				}catch(Exception er) {
					result.setText("Error: "+er);
				}
			}
			
		});
		subtract.setBounds(142, 163, 84, 20);
		contentPane.add(subtract);
		
		JButton multiply = new JButton("Multiply");
		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String firstNum = num1.getText();
				String secondNum = num2.getText();
				double Num1 = Double.parseDouble(firstNum);
				double Num2 = Double.parseDouble(secondNum);
				double sum = Num1 * Num2;
				result.setText(String.valueOf(sum));
				}catch(Exception er) {
					result.setText("Error: "+er);
				}
			
			}
		});
		multiply.setBounds(236, 163, 84, 20);
		contentPane.add(multiply);
		
		JButton division = new JButton("Division");
		division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String firstNum = num1.getText();
				String secondNum = num2.getText();
				double Num1 = Double.parseDouble(firstNum);
				double Num2 = Double.parseDouble(secondNum);
				double sum = Num1 / Num2;
				result.setText(String.valueOf(sum));
				}catch(Exception er) {
					result.setText("Error: "+er);
				}
			
			}
		});
		division.setBounds(330, 163, 84, 20);
		contentPane.add(division);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblResult.setBounds(48, 193, 102, 30);
		contentPane.add(lblResult);
		
		result = new JTextField();
		result.setColumns(10);
		result.setBounds(179, 200, 102, 19);
		contentPane.add(result);

	}

}
