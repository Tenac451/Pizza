package de.thb.dim.pizzaPronto.businessObjects.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import de.thb.dim.pizzaPronto.valueObjects.DessertVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.PastaVO;
import de.thb.dim.pizzaPronto.valueObjects.PizzaVO;

public class MenuImporter {
	public MenuVO readMenu() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("myLittleMenu.txt"));
			String line = reader.readLine();

			ArrayList<String> incredients = new ArrayList<String>();
			int number = 0;
			String name = null;
			float price = 0.0f;
			int size = 0;
			String type = null;
			int typeOfPasta = 0;
			LinkedList<DishVO> dishes = new LinkedList<DishVO>();
			while (line != null) {

				if (line.length() == 0) {

					if ("Pizza".equals(type)) {
						dishes.add(
							new PizzaVO(
									number,
									name,
									incredients.toArray(new String[incredients.size()]),
									price,
									size
									)
						);
					}
					if ("Pasta".equals(type)) {
						dishes.add(
								new PastaVO(
										number,
										name,
										incredients.toArray(new String[incredients.size()]),
										price,
										typeOfPasta
										)
							);
					}
					if ("Dessert".equals(type)) {
						dishes.add(
								new DessertVO(
										number,
										name,
										price
										)
							);
					}

					// reset
					incredients = new ArrayList<String>();
					name = null;
					type = null;
					number = 0;
					typeOfPasta = 0;
					size = 0;
					price = 0.0f;

				}

				String[] words = line.split(":");

				if (words[0].equals("dish.type")) {
					type = words[1];
				}
				if (words[0].equals("dish.nr")) {
					number = Integer.parseInt(words[1]);
				}
				if (words[0].equals("dish.name")) {
					name = words[1];
				}
				if (words[0].equals("dish.price")) {
					price = Float.parseFloat(words[1]);
				}
				if (words[0].equals("dish.incredient")) {
					incredients.add(words[1]);
				}
				if (words[0].equals("dish.typeOfPasta")) {
					incredients.add(words[1]);
				}
				if (words[0].equals("dish.size")) {
					size = Integer.parseInt(words[1]);
				}
		
				line = reader.readLine();
			}
			reader.close();
			System.out.println(dishes);
			return new MenuVO(new ArrayList<DishVO>(dishes));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
