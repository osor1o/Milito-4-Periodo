package listI;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Register extends JFrame {
	private static JFrame instance = null;
	private JLabel nameLabel = new JLabel("Name");
	private JLabel emailLabel = new JLabel("Email");
	private JLabel phoneNumberLabel = new JLabel("Phone Number");
	private JTextField nameField = new JTextField();
	private JTextField emailField = new JTextField();
	private JTextField phoneNumberField = new JTextField();
	private JButton registerButton = new JButton("Register");
	
	private Register() {
		GridLayout grid = new GridLayout(4, 2);
		this.setLayout(grid);
		
		this.add(nameLabel);
		this.add(nameField);
		this.add(emailLabel);
		this.add(emailField);
		this.add(phoneNumberLabel);
		this.add(phoneNumberField);
		this.add(registerButton);
		
		this.pack();
		this.setTitle("Register");
		this.setSize(300, 200);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static JFrame getInstance() {
		if(instance == null)
			instance = new Register();
		instance.setVisible(true);
		return instance;
	}
	
}
