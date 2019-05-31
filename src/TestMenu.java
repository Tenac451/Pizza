
public class TestMenu {

	public static void main(String[] args) {
		MenuVO menu = new MenuVO();
		DishVO dishes [] = new DishVO[MenuVO.getNumberOfDishes()];
			
			
		System.out.println(menu.toString());
		
		// Einmal die ganzen Speisen aus der Speisekarte abrufen
		// und ausgeben.
		
		System.out.println("\n");
		
		for(int i = 0; i < MenuVO.getNumberOfDishes();++i){
			dishes[i] = menu.getDish(i);
			System.out.println(dishes[i].toString());
		}

	}

}
