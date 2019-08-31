package listI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private JButton sumButton = new JButton("+");
	private JButton subtractionButton = new JButton("-");
	private JButton multiplicationButton = new JButton("*");
	private JButton divisionButton = new JButton("/");
	private JLabel number1Label = new JLabel("Number 1");
	private JLabel number2Label = new JLabel("Number 2");
	private JLabel resultLabel = new JLabel("Result");
	private JTextField number1Field = new JTextField();
	private JTextField number2Field = new JTextField();
	private JTextField resultField = new JTextField();
	private Listener listener = new Listener();
	
	public Calculator() {
		GridLayout grid = new GridLayout(3,4);
		this.setLayout(grid);
		this.add(number1Label);
		this.add(number1Field);
		this.add(sumButton);
		this.add(multiplicationButton);
		this.add(number2Label);
		this.add(number2Field);
		this.add(subtractionButton);
		this.add(divisionButton);
		this.add(resultLabel);
		this.add(resultField);
		
		sumButton.addActionListener(listener);
		subtractionButton.addActionListener(listener);
		multiplicationButton.addActionListener(listener);
		divisionButton.addActionListener(listener);
		
		this.setTitle("Calculator");
		this.pack();
		this.setVisible(true);
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double n1 = Double.parseDouble(number1Field.getText());
			double n2 = Double.parseDouble(number2Field.getText());
			double result = 0;
			
			if(e.getSource() == sumButton) {
				result = n1 + n2;
			}
			if(e.getSource() == subtractionButton) {
				result = n1 - n2;
			}
			if(e.getSource() == multiplicationButton) {
				result = n1 * n2;
			}
			if(e.getSource() == divisionButton) {
				result = n1 / n2;
			}
			
			resultField.setText(String.valueOf(result));
		}
	}
	
}
