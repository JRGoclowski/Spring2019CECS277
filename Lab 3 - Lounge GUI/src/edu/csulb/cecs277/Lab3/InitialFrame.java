package edu.csulb.cecs277.Lab3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InitialFrame extends JFrame {
	
	private JLabel options;
	
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton pastryButton;
	private JButton doneButton;
		
	private JScrollPane receiptPane;
	
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
			receiptPane.setVisible(true);
		}
		iF.repaint();
	}
	
	private void createComponents() {
		options = new JLabel("Select an item to purchase: ");
		receiptText = new JTextArea();
		receiptText.setEditable(false);
		receiptText.setVisible(false);
		
		receiptPane = new JScrollPane(receiptText);
		receiptPane.setPreferredSize(new Dimension(600, 350));
		receiptPane.setVisible(true);
		
		
		coffeeButton = new JButton("Coffee");
		ActionListener coffeeListener = new CoffeeButtonListener();
		coffeeButton.addActionListener(coffeeListener);
		
		teaButton = new JButton("Tea");
		ActionListener teaListener = new TeaButtonListener();
		teaButton.addActionListener(teaListener);
		
		pastryButton = new JButton("Pastry");
		ActionListener pastryListener = new PastryButtonListener();
		pastryButton.addActionListener(pastryListener);
		
		doneButton = new JButton("Done");
		ActionListener doneListener = new DoneButtonListener();
		doneButton.addActionListener(doneListener);
		doneButton.setVisible(false);
				
		JPanel initialPanel = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		JPanel receiptPanel = new JPanel();
		JPanel donePanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		

		//receiptPanel.setPreferredSize(new Dimension(800,500));
		//receiptPanel.setMinimumSize(new Dimension(720, 350));
		donePanel.setSize(20,40);
		
		buttonPanel.add(options, BorderLayout.LINE_START);
		buttonPanel.add(coffeeButton, BorderLayout.PAGE_START);
		buttonPanel.add(teaButton,BorderLayout.PAGE_START);
		buttonPanel.add(pastryButton);
		
		receiptPanel.add(receiptPane);
		
		donePanel.add(doneButton);
		
		initialPanel.add(buttonPanel, BorderLayout.NORTH);
		initialPanel.add(leftPanel, BorderLayout.WEST);
		initialPanel.add(rightPanel, BorderLayout.EAST);
		
		leftPanel.setPreferredSize(new Dimension(40,350));
		rightPanel.setPreferredSize(new Dimension(40,350));
		
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
