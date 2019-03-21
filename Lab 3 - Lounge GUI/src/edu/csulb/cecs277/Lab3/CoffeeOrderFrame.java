package edu.csulb.cecs277.Lab3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CoffeeOrderFrame extends JFrame {
	
	private JLabel instructions;
	
	private JComboBox<String> flavors;
	private JComboBox<String> size;
	private JComboBox<String> sugarTsp;
	private JComboBox<String> milkTypes;
	private JComboBox<String> temperature;
	
	private JButton save;
	private JButton cancel;
	
	private JTextField instructionField;
	
	private String[] drinkFeatures = new String[6];
	InitialFrame mainFrame;
	Receipt mainReceipt;
	
	/**
	 * Constructs a Tea Order Frame to build a tea drink
	 * @param main - the initial frame so that it can be
	 *  updated when drink is made
	 * @param receiptArg - The receipt that the drinks will
	 * be tracked on
	 */
	public CoffeeOrderFrame(InitialFrame main, Receipt receiptArg) {
		mainFrame = main;
		mainReceipt = receiptArg;
		createComponents();
		this.setTitle("New Coffee Order");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	/**
	 * Adds all the features of the coffee order frame, and 
	 * Formats it appropriately
	 */
	public void createComponents() {
		instructions = new JLabel("Special Instructions: ");
		
		String[] flavorOps = {"Regular", "Mocha", "Hazelnut", "Vanilla"};
		flavors = new JComboBox<String>(flavorOps);
		
		String[] sizeOps = {"S", "M", "L"};
		size = new JComboBox<String>(sizeOps);
		
		String[] sugarTspOps = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}; 
		sugarTsp = new JComboBox<String>(sugarTspOps);
		
		String[] milkOps = {"Whole Milk", "Half-and-half", "No Milk"}; 
		milkTypes = new JComboBox<String>(milkOps);
		
		String[] tempOps = {"Hot", "Iced", "Blended"};
		temperature = new JComboBox<String>(tempOps);
		
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		
		ActionListener saveListener = new SaveButtonListener();
		ActionListener cancelListener = new CancelButtonListener();
		
		save.addActionListener(saveListener);
		cancel.addActionListener(cancelListener);
		
		instructionField = new JTextField("Enter Instructions");
		instructionField.setColumns(40);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("Specify the Coffee Order: "));
		panel.add(new JLabel("Flavor: "));
		panel.add(flavors);
		panel.add(new JLabel("Size: "));
		panel.add(size);
		panel.add(new JLabel("Sugar: "));
		panel.add(sugarTsp);
		panel.add(new JLabel("Milk: "));
		panel.add(milkTypes);
		panel.add(new JLabel("Type: "));
		panel.add(temperature);
		panel.add(instructions);
		panel.add(instructionField);
		panel.add(save);
		panel.add(cancel);
		
		this.add(panel);
	}
	
	/**
	 * Creates an cancel button listener
	 * @author Jonathan
	 *
	 */
	class CancelButtonListener implements ActionListener {
		
		/**
		 * Button click listener that activates when the cancel is clicked
		 * updates the initial frame, and close the coffee frame
		 */
		public void actionPerformed(ActionEvent click) {
			mainFrame.update();
			setVisible(false);
		}
	}
	
	/**
	 * Creates a save button listener
	 * @author Jonathan
	 *
	 */
	class SaveButtonListener implements ActionListener {
		
		/**
		 * Button click listener that activates when the save is clicked
		 * Creates a coffee Drink based on current frame features, adds it
		 * to the receipt, updates the initial frame, and closes the coffee window
		 */
		public void actionPerformed(ActionEvent click) {
			drinkFeatures[0] = (String) size.getSelectedItem();
			drinkFeatures[1] = (String) flavors.getSelectedItem();
			drinkFeatures[2] = (String) sugarTsp.getSelectedItem();
			drinkFeatures[3] = (String) milkTypes.getSelectedItem();
			drinkFeatures[4] = (String) temperature.getSelectedItem();
			String instrString = (String) instructionField.getText();
			if (instrString.equals("Enter Instructions") || instrString.equals("")) {
				drinkFeatures[5] = "None";
			}
			else {
				drinkFeatures[5] = instrString;
			}
			
			CoffeeItem addCoffee = new CoffeeItem(drinkFeatures[0], drinkFeatures[1], drinkFeatures[2],
					drinkFeatures[3], drinkFeatures[4], drinkFeatures[5]);
			mainReceipt.AddItem(addCoffee);
			mainFrame.update();
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.setVisible(false);
		}
	} 
	
	/**
	 * Returns the drink features array
	 * @return String[] - drink features array
	 */
	public String[] getDrinkFeatures() {
		return drinkFeatures;
	}

}
