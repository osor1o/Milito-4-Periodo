package listI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame {
	private static JFrame instance = null;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private Listener listener = new Listener();
	private int turn;
	private final int MAX_TURN = 9;
	
	private TicTacToe() {
		GridLayout grid = new GridLayout(3, 3);
		this.setLayout(grid);
		
		for(int i = 0; i < 9; i++) {
			buttons.add(new JButton());
			JButton button = buttons.get(i);
			this.add(button);
			button.addActionListener(listener);
		}
		
		this.pack();
		this.setSize(300, 300);
		this.setResizable(false);
		this.setTitle("Tic Tac Toe");
		this.initialState();
	}
	
	public static JFrame getInstance() {
		if(instance == null)
			instance = new TicTacToe();
		instance.setVisible(true);
		return instance;
	}
	
	private void initialState() {
		turn = 1;
		for(JButton button : buttons)
			button.setText("");
	}
	
	private String getTurnSymbol() {
		if(turn % 2 == 0)
			return "X";
		return "O";
	}
	
	private boolean isWin() {
		return (
			isEqualsButtons(1, 2, 3) || isEqualsButtons(4, 5, 6) || isEqualsButtons(7, 8, 9) ||
			isEqualsButtons(1, 4, 7) || isEqualsButtons(2, 5, 8) || isEqualsButtons(3, 6, 9) ||
			isEqualsButtons(1, 5, 9) || isEqualsButtons(3, 5, 7)
		);
	}
	
	private boolean isEqualsButtons(int i1, int i2, int i3) {
		String b1 = buttons.get(i1 - 1).getText();
		String b2 = buttons.get(i2 - 1).getText();
		String b3 = buttons.get(i3 - 1).getText();
		return b1.equals(b2) && b2.equals(b3) && !b1.isEmpty();
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(JButton button : buttons)
				if(e.getSource() == button && button.getText().isEmpty()) {
					turn++;
					button.setText(getTurnSymbol());
					verifyFinished();
				}
		}
	}
	
	private void verifyFinished() {
		if(isWin())
			JOptionPane.showMessageDialog(null, "FINISHED! \"" + getTurnSymbol() +"\" WIN");
		else if(turn > MAX_TURN)
			JOptionPane.showMessageDialog(null, "FINISHED! Draw");
		if(isWin() || turn > MAX_TURN)
			initialState();
	}
}
