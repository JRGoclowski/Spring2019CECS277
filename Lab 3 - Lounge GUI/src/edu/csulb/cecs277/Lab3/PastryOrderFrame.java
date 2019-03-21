package edu.csulb.cecs277.Lab3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.csulb.cecs277.Lab3.CoffeeOrderFrame.CancelButtonListener;
import edu.csulb.cecs277.Lab3.CoffeeOrderFrame.SaveButtonListener;

public class PastryOrderFrame extends JFrame {
	
	private JComboBox<String> items;
	private JComboBox<String> flavors;
	
	private JLabel heated = new JLabel("Heated");
	
	private JPanel mainPanel;
		
	private JButton save;
	private JButton cancel;
	
	private JCheckBox heatOption = new JCheckBox();
	
	private InitialFrame mainFrame;
	private Receipt mainReceipt;
	
	/**
	 * Constructs the Pastry Order frame initially
	 * @param main - The initial frame of the program to update later
	 * @param receiptArg - The receipt that the pastry must be added to
	 */
	public PastryOrderFrame(InitialFrame main, Receipt receiptArg) {
		createComponentsBase();
		mainFrame = main;
		mainReceipt = receiptArg;
		this.setTitle("New Pastry Order");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	/**
	 * Creates the first version of the frame, without the flavor options available
	 */
	public void createComponentsBase() {
		String[] itemOps = {"Muffin", "Cookie", "Danish", "Cheesecake"};
		items = new JComboBox<String>(itemOps);
		
		ItemComboListener iCListener = new ItemComboListener();
		items.addActionListener(iCListener);
			
		cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelButtonListener();
		cancel.addActionListener(cancelListener);
		
		mainPanel = new JPanel();
		
		mainPanel.add(items);
		mainPanel.add(cancel);
		this.add(mainPanel);
	}
	
	/**
	 * Creates the muffin version of the frame, with the muffin flavor options available
	 */
	public void createComponentsMuffin() {
		String[] itemOps = {"Muffin", "Cookie", "Danish", "Cheesecake"};
		items = new JComboBox<String>(itemOps);		
		String[] flavorOps = {"Banana Nut", "Blueberry", "Chocolate Chip", "Coffee Cake"};
		flavors = new JComboBox<String>(flavorOps);
		items.setSelectedItem("Muffin");
		
		ItemComboListener iCListener = new ItemComboListener();
		items.addActionListener(iCListener);
		
		cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelButtonListener();
		cancel.addActionListener(cancelListener);
		
		save = new JButton("Save");
		ActionListener saveListener = new SaveButtonListener();
		save.addActionListener(saveListener);
		
		mainPanel.removeAll();
		mainPanel.revalidate();
		mainPanel.repaint();
		
		mainPanel.add(items);
		mainPanel.add(flavors);
		mainPanel.add(heatOption);
		mainPanel.add(heated);
		mainPanel.add(save);
		mainPanel.add(cancel);
		
		this.add(mainPanel);
	}
	
	/**
	 * Creates the cookie version of the frame, with the cookie flavor options available
	 */
	public void createComponentsCookie() {
		String[] itemOps = {"Muffin", "Cookie", "Danish", "Cheesecake"};
		items = new JComboBox<String>(itemOps);		
		String[] flavorOps = {"Oatmeal", "White Chocolate & Macadamias", "Chocolate Chip", "Double Fudge"};
		flavors = new JComboBox<String>(flavorOps);
		items.setSelectedItem("Cookie");
		
		ItemComboListener iCListener = new ItemComboListener();
		items.addActionListener(iCListener);
		
		cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelButtonListener();
		cancel.addActionListener(cancelListener);
		
		save = new JButton("Save");
		ActionListener saveListener = new SaveButtonListener();
		save.addActionListener(saveListener);
		
		mainPanel.removeAll();
		mainPanel.revalidate();
		mainPanel.repaint();
		
		mainPanel.add(items);
		mainPanel.add(flavors);
		mainPanel.add(heatOption);
		mainPanel.add(heated);
		mainPanel.add(save);
		mainPanel.add(cancel);
		
		this.add(mainPanel);
	}
	
	/**
	 * Creates the danish version of the frame, with the danish flavor options available
	 */
	public void createComponentsDanish() {
		String[] itemOps = {"Muffin", "Cookie", "Danish", "Cheesecake"};
		items = new JComboBox<String>(itemOps);		
		String[] flavorOps = {"Apple Cinnamon", "Strawberry & Cheeses", "Double Cheese"};
		flavors = new JComboBox<String>(flavorOps);
		items.setSelectedItem("Danish");
		
		ItemComboListener iCListener = new ItemComboListener();
		items.addActionListener(iCListener);
		
		cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelButtonListener();
		cancel.addActionListener(cancelListener);
		
		save = new JButton("Save");
		ActionListener saveListener = new SaveButtonListener();
		save.addActionListener(saveListener);
		
		mainPanel.removeAll();
		mainPanel.revalidate();
		mainPanel.repaint();
		
		mainPanel.add(items);
		mainPanel.add(flavors);
		mainPanel.add(heatOption);
		mainPanel.add(heated);
		mainPanel.add(save);
		mainPanel.add(cancel);
		
		this.add(mainPanel);

	}
	
	/**
	 * Creates the Cheesecake version of the frame, with the Cheesecake flavor options available
	 */
	public void createComponentsCheesecake() {
		String[] itemOps = {"Muffin", "Cookie", "Danish", "Cheesecake"};
		items = new JComboBox<String>(itemOps);		
		String[] flavorOps = {"Regular", "Cherry", "Blueberry"};
		flavors = new JComboBox<String>(flavorOps);
		items.setSelectedItem("Cheesecake");
		
		
		ItemComboListener iCListener = new ItemComboListener();
		items.addActionListener(iCListener);
		
		cancel = new JButton("Cancel");
		ActionListener cancelListener = new CancelButtonListener();
		cancel.addActionListener(cancelListener);
		
		save = new JButton("Save");
		ActionListener saveListener = new SaveButtonListener();
		save.addActionListener(saveListener);
		
		mainPanel.removeAll();
		mainPanel.revalidate();
		mainPanel.repaint();
		
		mainPanel.add(items);
		mainPanel.add(flavors);
		mainPanel.add(heatOption);
		mainPanel.add(heated);
		mainPanel.add(save);
		mainPanel.add(cancel);
		
		this.add(mainPanel);
	}
	
	/**
	 * Creates an Item Combobox listener
	 * @author Jonathan
	 *
	 */
	class ItemComboListener implements ActionListener {
		 
		/**
		 * Updates the frame based on the selected option, showing the right flavors
		 */
		public void actionPerformed(ActionEvent select) {
			String itemChoice = (String) items.getSelectedItem();
			switch (itemChoice) {
				case "Muffin": 
					createComponentsMuffin(); 
					mainPanel.revalidate();
					mainPanel.repaint();
					break;
				case "Cookie": 
					createComponentsCookie(); 
					mainPanel.revalidate();
					mainPanel.repaint();
					break;
				case "Danish": 
					createComponentsDanish(); 
					mainPanel.revalidate();
					mainPanel.repaint();
					break;
				case "Cheesecake": 
					createComponentsCheesecake(); 
					mainPanel.revalidate();
					mainPanel.repaint();
					break;
			}
		}
	}
	
	/**
	 * Creates an save button listener
	 * @author Jonathan
	 *
	 */
	class SaveButtonListener implements ActionListener {
		
		/**
		 * Creates a Pastry Item, adds it to the receipt,
		 * updates the initial frame, and closes the frame
		 */
		public void actionPerformed(ActionEvent click) {
			PastryItem addPastry = new PastryItem((String)items.getSelectedItem(), 
					(String)flavors.getSelectedItem(), heatOption.isSelected());
			mainReceipt.AddItem(addPastry);
			mainFrame.update();
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.setVisible(false);
		}
	} 
	
	/**
	 * Creates an cancel button listener
	 * @author Jonathan
	 *
	 */
	class CancelButtonListener implements ActionListener {
		
		/**
		  * updates the initial frame, and closes the frame
		  */
		public void actionPerformed(ActionEvent click) {
			mainFrame.update();
			setVisible(false);
		}
	}
	

}
