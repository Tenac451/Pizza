import java.text.DecimalFormat;

public class MenuVO {
	private static final int NUMBER_OF_DISHES = 18;
	private DishVO[] dishes;

	public MenuVO() {
		this.initMenuVO();
	}
	private void initMenuVO() {
		
		this.dishes = new DishVO[NUMBER_OF_DISHES];
		
		dishes[0] = new PizzaVO(30, "Popeye", new String[] { "Schinken","Spinat", "Champignon", "Ei" }, 7.00f, 1);
		dishes[1] = new PizzaVO(30, "Popeye", new String[] { "Schinken","Spinat", "Champignon", "Ei" }, 8.90f, 2);
		dishes[2] = new PizzaVO(31, "Hawaii", new String[] { "Schinken","Ananas", "Curry" }, 5.80f, 1);
		dishes[3] = new PizzaVO(31, "Hawaii", new String[] { "Schinken","Ananas", "Curry" }, 7.40f, 2);
		dishes[4] = new PizzaVO(32, "Prima", new String[] { "Schinken","Salami", "Zwiebeln", "Ei" }, 7.00f, 1);
		dishes[5] = new PizzaVO(32, "Prima", new String[] { "Schinken","Salami", "Zwiebeln", "Ei" }, 8.90f, 2);
		
		dishes[6] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },5.60f, 4);
		dishes[7] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },5.60f, 5);
		dishes[8] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },5.60f, 6);
		dishes[9] = new PastaVO(12, "Bolognese",new String[] { "Hackfleischsauce" }, 6.40f, 4);
		dishes[10] = new PastaVO(12, "Bolognese",new String[] { "Hackfleischsauce" }, 6.40f, 5);
		dishes[11] = new PastaVO(12, "Bolognese",new String[] { "Hackfleischsauce" }, 6.40f, 6);
		dishes[12] = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 4);
		dishes[13] = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 5);
		dishes[14] = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 6);
	
		dishes[15] = new DessertVO(21, "Hausgemachter Obstsalat", 2.30f);
		dishes[16] = new DessertVO(22, "Hausgemachte Pannacotta", 2.60f);
		dishes[17] = new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f);
		
		
		
	}
	public DishVO getDish(int index) {
		if(index < MenuVO.NUMBER_OF_DISHES) {
			return this.dishes[index];
		}
		return null;
	}
	public int getNumberOfDishes() {
		return MenuVO.NUMBER_OF_DISHES;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		DecimalFormat dFormat = new DecimalFormat(".00");
		int i = 0;
		
		sb.append("MENU PIZZA PRONTO\n\n");
		sb.append("Prima special pizzas: \n 1 normal (Diameter approx. 26 cm) and \n 2 grande (Diameter approx. 32 cm)\n");
		
		for(i = i; i < dishes.length && dishes[i] instanceof PizzaVO ; i = i + 1)
		{
			if (i == 0 || dishes[i-1].getNumber() != dishes[i].getNumber()) {
				sb.append(dishes[i].getNumber() + "\t");
				sb.append(dishes[i].getName() + "\t");
				sb.append(dishes[i].ingredientsToString());
				sb.append("\n");
			}
			sb.append("\tPrice:\t\t\t" + dFormat.format(dishes[i].getPrice()) + " Euro");
			sb.append("\n");
		}
		sb.append("\n");sb.append("\n");
		sb.append("Prima special pastas: \n 4 Spaghetti \n 5 Tortellini \n 6 Gnocchi \n");


		for(i = i; i < dishes.length && dishes[i] instanceof PastaVO ; i = i + 1)
		{
			if (i == 0 || dishes[i-1].getNumber() != dishes[i].getNumber()) {
				sb.append(dishes[i].getNumber() + "\t");
				sb.append(dishes[i].getName() + "\t");
				sb.append(dishes[i].ingredientsToString());
				sb.append("\n");
				sb.append("\tPrice:\t\t\t" + dFormat.format(dishes[i].getPrice()) + " Euro");
				sb.append("\n");
			}
		}
		
		sb.append("\n");sb.append("\n");
		sb.append("Prima desserts \n");
		
		for(i = i; i < dishes.length && dishes[i] instanceof DessertVO ; i = i + 1)
		{
			if (i == 0 || dishes[i-1].getNumber() != dishes[i].getNumber()) {
				sb.append(dishes[i].getNumber() + "\t");
				sb.append(dishes[i].getName() + "\t");
				sb.append(dishes[i].ingredientsToString());
				sb.append("\n");
				sb.append("\tPrice:\t\t\t" + dFormat.format(dishes[i].getPrice()) + " Euro");
				sb.append("\n");
			}

		}
		
		return sb.toString();
	}
}
