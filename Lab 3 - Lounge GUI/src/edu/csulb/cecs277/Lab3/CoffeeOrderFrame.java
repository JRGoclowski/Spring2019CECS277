package edu.csulb.cecs277.Lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CoffeeOrderFrame extends JFrame {
	
	private JLabel choices;
	private JLabel instructions;
	private JLabel flavor;
	private JLabel sizes;
	private JLabel sugar;
	private JLabel milk;
	private JLabel type;
	
	private JComboBox<String> flavors;
	private JComboBox<String> size;
	private JComboBox<String> sugarTsp;
	private JComboBox<String> milkTypes;
	private JComboBox<String> temperature;
	
	private JButton save;
	private JButton cancel;
	
	private JTextField instructionField;
	
	public CoffeeOrderFrame() {
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
			//TODO complete this
		}
	}
	
	class SaveButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent click) {
			//TODO complete this
		}
	}
	
	public static void main(String[] args) {
		CoffeeOrderFrame c = new CoffeeOrderFrame();
		c.setVisible(true);

	}

}
