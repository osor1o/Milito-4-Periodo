package listII;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JMenuItem temperatureConverter = new JMenuItem("Temperature Converter");
	private JMenuItem twoNdDegreeEquation = new JMenuItem("2nd Degree Equation");
	private JMenuItem decimalToBinaryAndHexadecimal = new JMenuItem("Decimal to Binary and Hexadecimal");
	private JMenuItem hotOrCold = new JMenuItem("Hot Or Cold");
	private JMenuItem ticTacToe = new JMenuItem("Tic Tac Toe");
	private JMenuItem register = new JMenuItem("Register");
	private JMenuItem exit = new JMenuItem("Exit");
	private Listener listener = new Listener();
	
	public static void main(String[] agrs) {
		MainFrame mf = new MainFrame();
	}
	
	public MainFrame () {
		this.setJMenuBar(menuBar);
		menuBar.add(exercices);
		
		exercices.add(temperatureConverter);
		exercices.add(twoNdDegreeEquation);
		exercices.add(decimalToBinaryAndHexadecimal);
		exercices.add(hotOrCold);
		exercices.add(ticTacToe);
		exercices.add(register);
		exercices.add(exit);
		
		temperatureConverter.addActionListener(listener);
		twoNdDegreeEquation.addActionListener(listener);
		decimalToBinaryAndHexadecimal.addActionListener(listener);
		hotOrCold.addActionListener(listener);
		ticTacToe.addActionListener(listener);
		register.addActionListener(listener);
		exit.addActionListener(listener);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == temperatureConverter) {
				TemperatureConverter tpc = new TemperatureConverter();
			}
			if(e.getSource() == twoNdDegreeEquation) {
				TwoNdDegreeEquation tnde = new TwoNdDegreeEquation();
			}
			if(e.getSource() == decimalToBinaryAndHexadecimal) {
				DecimalToBinaryAndHexadecimal dtbah = new DecimalToBinaryAndHexadecimal();
			}
			if(e.getSource() == hotOrCold) {
				HotOrCold hoc = new HotOrCold();
			}
			if(e.getSource() == ticTacToe) {
				TicTacToe ttt = new TicTacToe();
			}
			if(e.getSource() == register) {
				Register r = new Register();
				System.out.println("1");
			}
			if(e.getSource() == exit) {
				System.out.println("1");
				System.exit(0);
			}
		}
		
	}
}
