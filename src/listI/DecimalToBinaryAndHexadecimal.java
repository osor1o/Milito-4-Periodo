package listI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DecimalToBinaryAndHexadecimal extends JFrame {

	private JLabel valueLabel = new JLabel("value: ");
	private JLabel resultInHexadecimalLabel = new JLabel("hex: ");
	private JLabel resultInBinaryLabel = new JLabel("bin: ");
	private JTextField valueField = new JTextField();
	private JButton resultButton = new JButton("=");
	private Listener listener = new Listener();
	
	public DecimalToBinaryAndHexadecimal() {
		GridLayout grid = new GridLayout(3, 2);
		this.setLayout(grid);
		
		this.add(valueLabel);
		this.add(valueField);
		this.add(resultInBinaryLabel);
		this.add(resultInHexadecimalLabel);
		this.add(resultButton);
		resultButton.addActionListener(listener);
		
		this.pack();
		this.setSize(350, 150);
		this.setResizable(false);
		this.setTitle("Decimal to Binary and Hexadecimal");
		this.setVisible(true);
		int n1 = 100;
		int n2 = 16;
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == resultButton) {
				int value = Integer.parseInt(valueField.getText());
				
				String bin = Integer.toBinaryString(value);
				String hex = Integer.toHexString(value);
				
				resultInBinaryLabel.setText(bin);
				resultInHexadecimalLabel.setText(hex);
			}
		}
	}
}
