package de.thb.dim.pizzaPronto.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import de.thb.dim.pizzaPronto.businessObjects.*;
import de.thb.dim.pizzaPronto.valueObjects.*;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

public class TestService {

	public static void main(String[] args) {
		
		try {
			
			Kitchen kitchen = new Kitchen();
			CustomerVO customer1 = new CustomerVO("M", "Jan", LocalDate.of(1990, Month.APRIL, 29));
			OrderVO order = new OrderVO(0, StateOfOrderVO.STARTED, LocalDateTime.now(), customer1);
			
			kitchen.startService(order);
			System.out.println(order);
		} catch  (NullPointerException | CustomerTooYoungException | CustomerNoDateOfBirthException e) {
			System.err.println(e.getMessage());
		}
		

	}

}
