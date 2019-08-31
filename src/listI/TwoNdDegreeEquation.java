package listI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TwoNdDegreeEquation extends JFrame {
	private JLabel aLabel = new JLabel("a");
	private JLabel bLabel = new JLabel("b");
	private JLabel cLabel = new JLabel("c");
	private JLabel resultLabel = new JLabel("Result: ");
	private JButton resultButton = new JButton("=");
	private JTextField aField = new JTextField();
	private JTextField bField = new JTextField();
	private JTextField cField = new JTextField();
	private Listener listener = new Listener();
	
	public TwoNdDegreeEquation() {
		GridLayout grid = new GridLayout(4, 2);
		this.setLayout(grid);
		this.add(aLabel);
		this.add(aField);
		this.add(bLabel);
		this.add(bField);
		this.add(cLabel);
		this.add(cField);
		this.add(resultLabel);
		this.add(resultButton);
		resultButton.addActionListener(listener);
		
		this.pack();
		this.setTitle("2nd Degree Equation");
		this.setVisible(true);
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			double a = Double.parseDouble(aField.getText());
			double b = Double.parseDouble(bField.getText());
			double c = Double.parseDouble(cField.getText());
			double delta = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
			double x1 = (-b + delta) / (2*a);
			double x2 = (-b - delta) / (2*a);
			String result = "Result: " + x1 + " " + x2;
			resultLabel.setText(result);
		}
		
	}
}
