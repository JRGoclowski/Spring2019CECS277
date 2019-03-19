package edu.csulb.cecs277.Lab3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InitialFrame extends JFrame {
	
	private JLabel options;
	
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton pastryButton;
	private JButton doneButton;
		
	private JTextArea receiptText;
	
	private Receipt mReceipt;
	
	static private InitialFrame iF;
	
	
	public InitialFrame() {
		createComponents();
		mReceipt = new Receipt();
		this.setTitle("New Order");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void update() {
		doneButton.setVisible(true);
		if (!mReceipt.isEmpty()) {
			receiptText.setText(mReceipt.CreateFull());
			receiptText.setVisible(true);
		}
		iF.repaint();
	}
	
	private void createComponents() {
		options = new JLabel("Select an item to purchase: ");
		receiptText = new JTextArea();
		receiptText.setEditable(false);
		receiptText.setVisible(false);
		coffeeButton = new JButton("Coffee");
		teaButton = new JButton("Tea");
		pastryButton = new JButton("Pastry");
		doneButton = new JButton("Done");
		doneButton.setVisible(false);
		
		ActionListener coffeeListener = new CoffeeButtonListener();
		ActionListener teaListener = new TeaButtonListener();
		ActionListener pastryListener = new PastryButtonListener();
		ActionListener doneListener = new DoneButtonListener();
		
		coffeeButton.addActionListener(coffeeListener);
		teaButton.addActionListener(teaListener);
		pastryButton.addActionListener(pastryListener);
		doneButton.addActionListener(doneListener);
		
		JPanel initialPanel = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		JPanel receiptPanel = new JPanel();
		JPanel donePanel = new JPanel();
		
		receiptPanel.setSize(100,400);
		donePanel.setSize(20,40);
		
		buttonPanel.add(options, BorderLayout.LINE_START);
		buttonPanel.add(coffeeButton, BorderLayout.PAGE_START);
		buttonPanel.add(teaButton,BorderLayout.PAGE_START);
		buttonPanel.add(pastryButton);
		
		receiptPanel.add(receiptText);
		
		donePanel.add(doneButton);
		
		initialPanel.add(buttonPanel, BorderLayout.PAGE_START);
		initialPanel.add(receiptPanel, BorderLayout.CENTER);
		initialPanel.add(donePanel, BorderLayout.PAGE_END);
		
		this.add(initialPanel);		
	}
	
	class CoffeeButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			CoffeeOrderFrame cF = new CoffeeOrderFrame(iF, mReceipt);
			cF.setVisible(true);
		}
	}
	
	class TeaButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			TeaOrderFrame tF = new TeaOrderFrame(iF, mReceipt);
			tF.setVisible(true);
		}
	}
	
	class PastryButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			PastryOrderFrame pF = new PastryOrderFrame(iF, mReceipt);
			pF.setVisible(true);
		}
	}
	
	class DoneButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			if (!mReceipt.isEmpty()) {
				FinalizeOrderFrame fF = new FinalizeOrderFrame(mReceipt);
				fF.setVisible(true);
			}
			else {
				System.exit(0);
			}
		}
	}
	
	public Receipt getMReceipt() {
		return mReceipt;
	}
	
	public static void main (String[] args) {
		iF = new InitialFrame();
		iF.setVisible(true);
	}
	
}
