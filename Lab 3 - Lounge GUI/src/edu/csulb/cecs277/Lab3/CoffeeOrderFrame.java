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
	
	public CoffeeOrderFrame(InitialFrame mFrame, Receipt receiptArg) {
		mainFrame = mFrame;
		mainReceipt = receiptArg;
		createComponents();
		this.setTitle("New Coffee Order");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
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

	class CancelButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			mainFrame.update();
			setVisible(false);
		}
	}
	
	class SaveButtonListener implements ActionListener {
		
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
	
	public String[] getDrinkFeatures() {
		return drinkFeatures;
	}

}
