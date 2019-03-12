package edu.csulb.cecs277.Lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeaItemTest {
	TeaItem tNM = new TeaItem("M", "Green", "full", "No Milk");
	TeaItem tM = new TeaItem("M", "Green", "full", "Whole Milk");
	TeaItem tTNM = new TeaItem("M", "Green", "full", "No Milk");
	TeaItem tTM = new TeaItem("M", "Green", "full", "Whole Milk");

	@Test
	public void testAddTopping() {
		tTNM.addTopping("Boba");
	}

	
	public void AddTop() {
		tTNM.addTopping("Boba");
		tTNM.addTopping("Lychee Jelly");
		tTM.addTopping("Boba");
		tTM.addTopping("Lychee Jelly");
	}
	
	@Test
	public void testCalculateCost() {
		AddTop();
		double tNMC, tMC, tTNMC, tTMC;
		tNMC = tNM.calculateCost();
		tMC = tM.calculateCost();
		tTNMC = tTNM.calculateCost();
		tTMC = tTM.calculateCost();
		assertEquals(3.00 ,tNMC, 0);
		assertEquals(3.25 ,tMC, 0);
		assertEquals(3.50 ,tTNMC, 0);
		assertEquals(3.75 ,tTMC, 0);
	}

	@Test
	public void testToString() {
		AddTop();
		String tNMS, tMS, tTNMS, tTMS;
		tNMS = tNM.toString();
		tMS = tM.toString();
		tTNMS = tTNM.toString();
		tTMS = tTM.toString();
		assertEquals("M Green Tea full sweetened with No Milk and no toppings",tNMS);
		assertEquals("M Green Tea full sweetened with Whole Milk and no toppings", tMS);
		assertEquals("M Green Tea full sweetened with No Milk and Boba, and Lychee Jelly" ,tTNMS);
		assertEquals("M Green Tea full sweetened with Whole Milk and Boba, and Lychee Jelly", tTMS);
	}

}
