package de.thb.dim.pizzaPronto.controller;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import de.thb.dim.pizzaPronto.businessObjects.io.Serializer;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.PizzaVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

public class TestSerialize {

	public static void main(String[] args) {
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
				//Serializer s = new Serializer("test");
				Serializer s = new Serializer("Order.ser");
				s.serializeOrder(o1);
				System.out.println(o1);
				o4 = s.deserializeOrder();
				System.out.println(o4);
				
				s.closeInput();
				s.closeOutput();
				
				if(o4 != null) {
					System.out.println(o4.equals(o1));
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NullPointerException | CustomerTooYoungException | CustomerNoDateOfBirthException e) {
			// TODO Auto-generated catch block
			System.err.println("Oops an error ocurred");
			//e.printStackTrace();
		}
	}	

}
