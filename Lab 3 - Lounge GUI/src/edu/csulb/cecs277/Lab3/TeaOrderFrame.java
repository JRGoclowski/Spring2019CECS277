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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.csulb.cecs277.Lab3.CoffeeOrderFrame.CancelButtonListener;
import edu.csulb.cecs277.Lab3.CoffeeOrderFrame.SaveButtonListener;

public class TeaOrderFrame extends JFrame {

	private JLabel choices;
	private JLabel flavor;
	private JLabel sizes;
	private JLabel sugar;
	private JLabel milk;
	private JLabel type;
	
	private JComboBox<String> flavors;
	private JComboBox<String> size;
	private JComboBox<String> sweetness;
	private JComboBox<String> milkTypes;
	
	private JButton save;
	private JButton cancel;
	
	private JCheckBox boba;
	private JCheckBox poppingBoba;
	private JCheckBox grassJelly;
	private JCheckBox lycheeJelly;
	private JCheckBox coconutJelly;
	private JCheckBox miniMochi;
	
	private InitialFrame mainFrame;
	private Receipt mainReceipt;
	private String[] drinkFeatures = new String[4];
	
	public TeaOrderFrame(InitialFrame main, Receipt receiptArg) {
		createComponents();
		mainFrame = main;
		mainReceipt = receiptArg;
		this.setTitle("New Tea Order");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void createComponents() {
		
		String[] flavorOps = {"Green", "Black", "Jasmine Green", "Rose", "Oolong"};
		flavors = new JComboBox<String>(flavorOps);
		
		String[] sizeOps = {"S", "M", "L"};
		size = new JComboBox<String>(sizeOps);
		
		String[] sweetOps = {"full sweetnened", "3/4 sweetened", "1/2 sweetened", "1/4 sweetened", "unsweetened"}; 
		sweetness = new JComboBox<String>(sweetOps);
		
		String[] milkOps = {"Whole Milk", "Half-and-half", "No Milk"}; 
		milkTypes = new JComboBox<String>(milkOps);
		
		boba = new JCheckBox("Boba");
		poppingBoba = new JCheckBox("Popping Boba");
		grassJelly = new JCheckBox("Grass Jelly");
		lycheeJelly = new JCheckBox("Lychee Jelly");
		coconutJelly = new JCheckBox("Coconut Jelly");
		miniMochi = new JCheckBox("Mini Mochi");
		
		
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		
		ActionListener saveListener = new SaveButtonListener();
		ActionListener cancelListener = new CancelButtonListener();
		
		save.addActionListener(saveListener);
		cancel.addActionListener(cancelListener);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("Specify the Coffee Order: "));
		panel.add(new JLabel("Tea: "));
		panel.add(flavors);
		panel.add(new JLabel("Size: "));
		panel.add(size);
		panel.add(new JLabel("Sweetness: "));
		panel.add(sweetness);
		panel.add(new JLabel("Milk: "));
		panel.add(milkTypes);
		panel.add(boba);
		panel.add(poppingBoba);
		panel.add(grassJelly);
		panel.add(lycheeJelly);
		panel.add(coconutJelly);
		panel.add(miniMochi);
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
			drinkFeatures[2] = (String) sweetness.getSelectedItem();
			drinkFeatures[3] = (String) milkTypes.getSelectedItem();
			TeaItem addTea = new TeaItem(drinkFeatures[0], drinkFeatures[1], drinkFeatures[2],
					drinkFeatures[3]);
			if (boba.isSelected()) { addTea.addTopping("Boba");}
			if (poppingBoba.isSelected()) { addTea.addTopping("Popping Boba");}
			if (grassJelly.isSelected()) { addTea.addTopping("Grass Jelly");}
			if (lycheeJelly.isSelected()) { addTea.addTopping("Lychee Jelly");}
			if (coconutJelly.isSelected()) { addTea.addTopping("Coconut Jelly");}
			if (miniMochi.isSelected()) { addTea.addTopping("Mini Mochi");}
			mainReceipt.AddItem(addTea);
			mainFrame.update();
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.setVisible(false);
		}
	}
	

}