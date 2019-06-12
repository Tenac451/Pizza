package de.thb.dim.pizzaPronto.controller;

import java.time.LocalDate;
import java.time.Month;

import de.thb.dim.pizzaPronto.businessObjects.Ordering;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

public class TestOrderingService {

	public static void main(String[] args) {

		CustomerVO customer1;
		Ordering o;
		
		try {
			customer1 = new CustomerVO("M", "Jan", LocalDate.of(1990, Month.APRIL, 29));
			o = new Ordering();
			o.startNewOrder(customer1);
			System.out.println(o.getCurrentOrder().getState());
			try {
				o.confirmOrder();
			} catch (NoCustomerException | NoOrderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
