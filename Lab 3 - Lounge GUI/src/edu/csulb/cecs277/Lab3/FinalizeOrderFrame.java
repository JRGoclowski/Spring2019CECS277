package edu.csulb.cecs277.Lab3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.csulb.cecs277.Lab3.PastryOrderFrame.CancelButtonListener;

public class FinalizeOrderFrame extends JFrame {
	
	JPanel initialPanel;
	JPanel totalPanel;
	JPanel receiptPanel;
	JPanel payPanel;
		
	private JLabel amountDueLabel;
	private JLabel totalCostLabel;
	private JLabel paymentLabel;
	private JLabel insuffLabel = new JLabel("Insufficient Payment! Amount Still Due: $");
	
	private JButton payButton;
	
	private JTextArea receiptText;
	
	private JTextField paymentField;
	
	private Receipt mainReceipt;
	
	DecimalFormat df = new DecimalFormat("#0.00");
	
	double paymentOffered, amountPaid = 0, amountInsuff = 0, totalDue, changeDue;
	
	private String grandString, receiptString;
	
		
	public FinalizeOrderFrame(Receipt receiptArg) {
		mainReceipt = receiptArg;
		
		totalDue = mainReceipt.getGrandTotal();
		grandString = mainReceipt.getGrandString();
		receiptString = mainReceipt.CreateFull();
		
		createComponents();
		
		this.setTitle("Finalize Order");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void createComponents() {
		amountDueLabel = new JLabel("Amount Due: $");
		totalCostLabel = new JLabel(grandString);
		paymentLabel = new JLabel("Payment: $");
		receiptText = new JTextArea(receiptString);
		paymentField = new JTextField(grandString);
		
		initialPanel = new JPanel(new BorderLayout());
		totalPanel = new JPanel();
		receiptPanel = new JPanel();
		payPanel = new JPanel();
		
		payButton = new JButton("Pay");
		ActionListener payListener = new PayButtonListener();
		payButton.addActionListener(payListener);
		
		totalPanel.add(amountDueLabel);
		totalPanel.add(totalCostLabel);
		receiptPanel.add(receiptText);
		payPanel.add(paymentLabel);
		payPanel.add(paymentField);
		payPanel.add(payButton);
		
		initialPanel.add(totalPanel, BorderLayout.NORTH);
		initialPanel.add(receiptPanel, BorderLayout.CENTER);
		initialPanel.add(payPanel, BorderLayout.SOUTH);
		
		this.add(initialPanel);
	}
	
	public void updateInsuff() {
		totalPanel.removeAll();
		totalPanel.revalidate();
		totalPanel.repaint();
		initialPanel.revalidate();
		initialPanel.repaint();
		totalPanel.add(insuffLabel);
		totalPanel.add(new JLabel(df.format(amountInsuff)));
		//paymentField = new JTextField(df.format(amountInsuff));
		totalPanel.revalidate();
		totalPanel.repaint();
		initialPanel.revalidate();
		initialPanel.repaint();
	}
	
	public void updatePaid() {
		totalPanel.removeAll();
		payPanel.removeAll();
		totalPanel.revalidate();
		totalPanel.repaint();
		initialPanel.revalidate();
		initialPanel.repaint();
		totalPanel.add(new JLabel("Thank You!"));
		
		receiptString += "\n\nPayment: $" + df.format(amountPaid) 
			+ "\nChange Due: $" + df.format(changeDue);
		receiptText.setText(receiptString);
		
		JButton exitButton = new JButton("Exit");
		ActionListener exitListener = new ExitButtonListener();
		exitButton.addActionListener(exitListener);
		
		payPanel.add(exitButton);
		
		
		totalPanel.revalidate();
		totalPanel.repaint();
		initialPanel.revalidate();
		initialPanel.repaint();
	}
	
	class PayButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			paymentField.revalidate();
			paymentOffered = Double.parseDouble(paymentField.getText()); 
			if (amountInsuff == 0 ) {
				if (paymentOffered < totalDue) {
					amountPaid += paymentOffered;
					amountInsuff = totalDue - paymentOffered;
					updateInsuff();
				}
				else {
					amountPaid += paymentOffered;
					changeDue = amountPaid - totalDue;
					updatePaid();
				}
			}
			else {
				if (paymentOffered < amountInsuff) {
					amountPaid += paymentOffered;
					amountInsuff = amountInsuff - paymentOffered;
					updateInsuff();
				}
				else {
					amountPaid += paymentOffered;
					changeDue = amountPaid - totalDue;
					updatePaid();
				}
			}
		}
	}
	
	class ExitButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			System.exit(0);
		}
	}
}