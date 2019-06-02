package de.thb.dim.pizzaPronto.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

import de.thb.dim.pizzaPronto.businessObjects.*;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.*;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

class TestDriver {

	public static void main(String[] args) {

		MenuVO menu;
		CustomerVO customer1,customer2;
		Ordering ordering1, ordering2;
		Random zufall = new Random();
		
		PizzaVO pizza = new PizzaVO(30, "Popeye", new String[] { "Schinken",
				"Spinat", "Champignon", "Ei" }, 7.00f, 1);
		try {
			PizzaVO cloneP = (PizzaVO) pizza.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			customer1 = new CustomerVO("M", "Jan", LocalDate.of(1990, Month.APRIL, 29));
			ordering1 = new Ordering();
			ordering1.startNewOrder(customer1);
			try {
				ordering1.confirmOrder();
			} catch (NoCustomerException | NoOrderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				ordering1.startService();
//			} catch (Exception e) {
//				System.err.println(e.getMessage());
//			}
			
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CustomerTooYoungException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CustomerNoDateOfBirthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
	}
	
	
}
