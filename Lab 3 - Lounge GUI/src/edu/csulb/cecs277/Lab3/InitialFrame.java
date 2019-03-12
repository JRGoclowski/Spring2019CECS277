package edu.csulb.cecs277.Lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InitialFrame extends JFrame {
	
	private JLabel options;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton pastryButton;
	private JButton doneButton;
	
	public InitialFrame() {
		createComponents();
		
		this.setTitle("New Order");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createComponents() {
		options = new JLabel("Select an item to purchase: ");
		
		coffeeButton = new JButton("Coffee");
		teaButton = new JButton("Tea");
		pastryButton = new JButton("Pastry");
		doneButton = new JButton("Done");
		
		ActionListener coffeeListener = new CoffeeButtonListener();
		ActionListener teaListener = new TeaButtonListener();
		ActionListener pastryListener = new PastryButtonListener();
		ActionListener doneListener = new DoneButtonListener();
		
		coffeeButton.addActionListener(coffeeListener);
		teaButton.addActionListener(teaListener);
		pastryButton.addActionListener(pastryListener);
		doneButton.addActionListener(doneListener);
		
		JPanel initialPanel = new JPanel();
		initialPanel.add(options);
		initialPanel.add(coffeeButton);
		initialPanel.add(teaButton);
		initialPanel.add(pastryButton);
		initialPanel.add(doneButton);
		
		this.add(initialPanel);		
	}
	
	class CoffeeButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			CoffeeOrderFrame cF = new CoffeeOrderFrame();
			cF.setVisible(true);
		}
	}
	
	class TeaButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			TeaOrderFrame tF = new TeaOrderFrame();
			tF.setVisible(true);
		}
	}
	
	class PastryButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			PastryOrderFrame pF = new PastryOrderFrame();
			pF.setVisible(true);
		}
	}
	
	class DoneButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			FinalizeOrderFrame fF = new FinalizeOrderFrame();
			fF.setVisible(true);
		}
	}
	
	public static void main (String[] args) {
		InitialFrame iF = new InitialFrame();
		iF.setVisible(true);
	}
	
}
