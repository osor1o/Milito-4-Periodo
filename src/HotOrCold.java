import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HotOrCold extends JFrame {
	
	private JLabel guessLabel = new JLabel("Guess: ");
	private JTextField guessField = new JTextField();
	private JButton guessButton = new JButton("Try");
	private int numberOfGuess;
	private int answer;
	private int actualGuess;
	private Listener listener = new Listener();
	
	public HotOrCold() {
		this.resetState();
		GridLayout grid = new GridLayout(2, 2);
		this.setLayout(grid);
		this.add(guessLabel);
		this.add(guessField);
		this.add(guessButton);
		guessButton.addActionListener(listener);
		
		this.pack();
		this.setTitle("Hot Or Cold");
		this.setSize(350, 150);
		this.setVisible(true);
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == guessButton) {
				String message;
				int value = Integer.parseInt(guessField.getText());
				if (Math.abs(value - answer) < Math.abs(actualGuess - answer)) {
					message = "HOT!";
				} else {
					message = "Cold";
				}
				actualGuess = value;
				numberOfGuess++;
				if(answer == value) {
						message = "won at " + numberOfGuess + " guess!";
						resetState();
				}
				JOptionPane.showMessageDialog(null, message);
			}
		}
		
	}
	
	private void resetState() {
		Random random = new Random();
		this.answer = random.nextInt(101);
		this.numberOfGuess = 0;
		this.actualGuess = 0;
		this.guessField.setText("");
	}
}
