package de.thb.dim.pizzaPronto.controller;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;

import de.thb.dim.pizzaPronto.businessObjects.*;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.businessObjects.io.MenuImporter;
import de.thb.dim.pizzaPronto.businessObjects.io.Serializer;
import de.thb.dim.pizzaPronto.valueObjects.*;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

class TestDriver {

	public static void main(String[] args) {

//		MenuVO menu;
//		CustomerVO customer1,customer2;
//		Ordering ordering1, ordering2;
//		Random zufall = new Random();
//		
//		PizzaVO pizza = new PizzaVO(30, "Popeye", new String[] { "Schinken",
//				"Spinat", "Champignon", "Ei" }, 7.00f, 1);
//		try {
//			PizzaVO cloneP = (PizzaVO) pizza.clone();
//			System.out.println(pizza);
//			System.out.println();
//		} catch ( InternalError  e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			customer1 = new CustomerVO("M", "Jan", LocalDate.of(1990, Month.APRIL, 29));
//			ordering1 = new Ordering();
//			ordering1.startNewOrder(customer1);
//			try {
//				ordering1.confirmOrder();
//			} catch (NoCustomerException | NoOrderException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		} catch (NullPointerException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (CustomerTooYoungException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (CustomerNoDateOfBirthException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			Kitchen kitchen = new Kitchen();
//			CustomerVO customer1 = new CustomerVO("M", "Jan", LocalDate.of(1990, Month.APRIL, 29));
//			OrderVO order = new OrderVO(0, StateOfOrderVO.STARTED, LocalDateTime.now(), customer1);
//			
//			kitchen.startService(order);
//			System.out.println(order);
//		} catch  (NullPointerException | CustomerTooYoungException | CustomerNoDateOfBirthException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		/**
//		 * Sorting Test
//		 */
//		try {
//			CustomerVO customer3 = new CustomerVO("M", "Jan", LocalDate.of(1990, Month.APRIL, 29));
//			Ordering ordering3 = new Ordering();
//			ordering3.startNewOrder(customer3);
//			for (int i = 0; i < 10; i++) {
//			    int random = (int)(Math.random() * (10) );
//			    ordering3.addDish(Ordering.getMenu().getDish(random));
//			}
//			System.out.println(ordering3.getCurrentOrder());
//			System.out.println("###################");
//			ordering3.sortShoppingBasket();
//			System.out.println(ordering3.getCurrentOrder());
//			System.out.println("###################");
//			ordering3.sortShoppingBasketByNumber();
//			System.out.println(ordering3.getCurrentOrder());
//			System.out.println("###################");
//			ordering3.sortShoppingBasketByPrice();
//			System.out.println(ordering3.getCurrentOrder());
//			System.out.println("###################");
//		} catch  (NullPointerException | CustomerTooYoungException | CustomerNoDateOfBirthException | IllegalStateException | NoOrderException e) {
//			System.err.println(e.getMessage());
//		}
//		MenuImporter imp = new MenuImporter();
//		MenuVO menu = imp.readMenu();
//		System.out.println(menu);
		
		CustomerVO c1,c2,c3;
		OrderVO o4;
		try {
			c1 = new CustomerVO("M", "Jan", LocalDate.of(1990, Month.APRIL, 29));
			c2 = new CustomerVO("M", "Paul", LocalDate.of(1990, Month.APRIL, 29));
			c3 = new CustomerVO("M", "David", LocalDate.of(1990, Month.APRIL, 29));
			OrderVO o1 = new OrderVO(0, StateOfOrderVO.STARTED, LocalDateTime.now(), c1);
			OrderVO o2 = new OrderVO(0, StateOfOrderVO.STARTED, LocalDateTime.now(), c2);
			OrderVO o3 = new OrderVO(0, StateOfOrderVO.STARTED, LocalDateTime.now(), c3);
			PizzaVO d1 = new PizzaVO(30, "Popeye", new String[] { "Schinken", "Spinat", "Champignon", "Ei" }, 7.00f, 1);
			o1.addDish(d1);
			try {
				Serializer s = new Serializer("Order.ser");
				s.serializeOrder(o1);
				System.out.println(o1);
				o4 = s.deserializeOrder();
				System.out.println(o4);
				
				System.out.println(o4.equals(o1));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NullPointerException | CustomerTooYoungException | CustomerNoDateOfBirthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}// 
}

