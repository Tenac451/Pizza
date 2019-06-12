package de.thb.dim.pizzaPronto.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;

import de.thb.dim.pizzaPronto.businessObjects.*;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.*;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

public class TestSorting {

	public static void main(String[] args) {

		try {
			CustomerVO customer3 = new CustomerVO("M", "Jan", LocalDate.of(1990, Month.APRIL, 29));
			Ordering ordering3 = new Ordering();
			ordering3.startNewOrder(customer3);
			for (int i = 0; i < 10; i++) {
			    int random = (int)(Math.random() * (10) );
			    ordering3.addDish(Ordering.getMenu().getDish(random));
			}
			System.out.println(ordering3.getCurrentOrder());
			System.out.println("###################");
			ordering3.sortShoppingBasket();
			System.out.println(ordering3.getCurrentOrder());
			System.out.println("###################");
			ordering3.sortShoppingBasketByNumber();
			System.out.println(ordering3.getCurrentOrder());
			System.out.println("###################");
			ordering3.sortShoppingBasketByPrice();
			System.out.println(ordering3.getCurrentOrder());
			System.out.println("###################");
		} catch  (NullPointerException | CustomerTooYoungException | CustomerNoDateOfBirthException | IllegalStateException | NoOrderException e) {
			System.err.println(e.getMessage());
		}
	}

}
