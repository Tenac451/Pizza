package de.thb.dim.pizzaPronto.controller;

import de.thb.dim.pizzaPronto.valueObjects.PizzaVO;

public class TestCloneDishVO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaVO pizza = new PizzaVO(30, "Popeye", new String[] { "Schinken",
				"Spinat", "Champignon", "Ei" }, 7.00f, 1);
		try {
			PizzaVO cloneP = (PizzaVO) pizza.clone();
			
			System.out.println(pizza);
			System.out.println(cloneP.equals(pizza));
			
		} catch ( InternalError  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
