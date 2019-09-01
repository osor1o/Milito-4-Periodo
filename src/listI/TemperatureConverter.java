package listI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TemperatureConverter extends JFrame {
	private static JFrame instance = null;
	private JTextField valueField = new JTextField();
	private JLabel valueLabel = new JLabel("Value: ");
	private JLabel resultLabel = new JLabel("Result: ");
	private JButton fahrenheitToCelsiusButton = new JButton("Fahrenheit To Celsius");
	private JButton celsiusToFahrenheitButton = new JButton("Celsius To Fahrenheit");
	private Listener listener = new Listener();
	
	private TemperatureConverter() {
		GridLayout grid = new GridLayout(3,2);
		this.setLayout(grid);
		this.add(valueLabel);
		this.add(valueField);
		this.add(fahrenheitToCelsiusButton);
		this.add(celsiusToFahrenheitButton);
		this.add(resultLabel);
		celsiusToFahrenheitButton.addActionListener(listener);
		fahrenheitToCelsiusButton.addActionListener(listener);
		
		this.pack();
		this.setVisible(true);
		this.setTitle("TemperatureConverter");
	}
	
	public static JFrame getInstance() {
		if(instance == null)
			instance = new TemperatureConverter();
		instance.setVisible(true);
		return instance;
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double value = Double.parseDouble(valueField.getText());
			double result = 0;
			
			if(e.getSource() == celsiusToFahrenheitButton) {
				result = (value * 9/5) + 32;
				// (32 °C × 9/5) + 32 = 89,6 °F
			}
			if(e.getSource() == fahrenheitToCelsiusButton) {
				result = (value - 32) * 5/9;
				//(32 °F − 32) × 5/9 = 0 °C
			}
			
			resultLabel.setText("Result: " + String.valueOf(result));
		}
	}
	
}
