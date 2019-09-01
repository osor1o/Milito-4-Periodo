package listII;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listI.DecimalToBinaryAndHexadecimal;
import listI.HotOrCold;
import listI.TemperatureConverter;
import listI.TicTacToe;
import listI.TwoNdDegreeEquation;

public class MainFrame extends JFrame
{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu exercices = new JMenu("Exercices");
	private String[] menuItemsKeys = {
		"Calculator", "Temperature Converter", "Two Nd Degree Equation", "Decimal To Binary And Hexadecimal",
		"Hot Or Cold", "Tic Tac Toe", "Register", "Exit"
	};
	private HashMap<String, JMenuItem> menuItems = new HashMap<String, JMenuItem>();
	private Listener listener = new Listener();
	
	public static void main(String[] agrs) {
		MainFrame mf = new MainFrame();
	}
	
	public MainFrame () {
		this.setJMenuBar(menuBar);
		menuBar.add(exercices);
		
		for(String key : menuItemsKeys) {
			menuItems.put(key, new JMenuItem(key));
			JMenuItem item = menuItems.get(key);
			exercices.add(item);
			item.addActionListener(listener);
			
		}
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	private void getInstance (String name) {
		try {
			if(name.equals("Exit"))
				System.exit(0);
			name = "listI." + name.replace(" ", "");
			Class.forName(name).getMethod("getInstance").invoke(null, null);
		} catch (
				IllegalAccessException | ClassNotFoundException | IllegalArgumentException | 
				NoSuchMethodException | SecurityException | InvocationTargetException e1
			) {
			e1.printStackTrace();
		}
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(String key : menuItemsKeys)
				if(e.getSource() == menuItems.get(key))
					getInstance(key);
		}
	}
}
