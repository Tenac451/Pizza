package de.thb.dim.pizzaPronto.controller;

import de.thb.dim.pizzaPronto.businessObjects.io.MenuImporter;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;

public class TestMenuImporter {

	public static void main(String[] args) {
		
		MenuImporter imp = new MenuImporter();
		MenuVO menu = imp.readMenu();
		System.out.println(menu);

	}

}
