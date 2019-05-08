import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class TestDriver {

	public static void main(String[] args) {
		
	
		System.out.println("####### --  Pizza BestellSystem Testsetup -- ######");
		System.out.println("####### --  Erstellen von PizzaVO Objekten -- ######");
		
		PizzaVO bocusespecial = new PizzaVO();
		PizzaVO salami = new PizzaVO(30,"bela Salami", new String[]  {"Salami" ,"Gauda"} , 6.50f);
		PizzaVO funghi = new PizzaVO(31,"el Funghi", new String[]  {"Champion" ,"Gauda"} , 6.50f);
		PizzaVO tonno = new PizzaVO(32,"Tonno", new String[]  {"Thundfisch", "Tomaten", "rote Zwiebeln" ,"Gauda"} , 7.50f);
		PizzaVO hawaii = new PizzaVO(33,"USA Hawaii Classic", new String[]  {"Kochschinken", "Annanas" ,"Gauda"} , 8.20f);
		PizzaVO quadro = new PizzaVO(34,"4 Käse", new String[]  {"Mozerella", "Ziegenkäse", "Gorgonzola" ,"Gauda"} , 9.50f);
		PizzaVO[] pizzen = {bocusespecial, salami, funghi, tonno, hawaii, quadro};
		
		for (PizzaVO pizza : pizzen) {
			System.out.println(pizza);
            System.out.println(pizza.ingredientsToString());
        } 
		
		System.out.println();
		System.out.println("####### --  erstellen von CustomerVO  -- ######");
		System.out.println();

		CustomerVO martin = new CustomerVO();
		CustomerVO timo = new CustomerVO("Timo", "Hansen", CustomerVO.M, LocalDate.of(1700, 5, 24));
		CustomerVO jule = new CustomerVO("Jule", "Hansen", CustomerVO.W, LocalDate.of(1998, 5, 24));
		CustomerVO kirsten = new CustomerVO("Kirsten", "Hansen", CustomerVO.D, LocalDate.of(1980, 5, 21));
		CustomerVO stefan = new CustomerVO("Stefan", "Hansen", "Telegrafenberg", 2 , CustomerVO.M, LocalDate.of(2005, 1, 1));
		CustomerVO steffi = new CustomerVO("Steffi", "Hansen", "Einsteinstraße", 12 , CustomerVO.M, LocalDate.of(1985, 1, 1));
		
		CustomerVO[] kunden = {martin, timo, jule, kirsten, stefan, steffi};
		
		for (CustomerVO kunde : kunden) {
            System.out.println(kunde);
        } 
		
		System.out.println();
		System.out.println("####### --  Personal Erstellen -- ######");
		System.out.println();
		
		
		DeliveryManVO mario = new DeliveryManVO("1", "Superfasti", "Mario");
		ChefVO bocuse = new ChefVO("01","Bocuse", "Brune");
		ChefVO pocuse = new ChefVO("Pocuse", "Peter", Color.RED);
		
		EmployeeVO[] employees = {mario, bocuse, pocuse};
		
		for (EmployeeVO employee : employees) {			 
            System.out.println(employee);
        } 
		
		System.out.println();
		System.out.println("####### --  Orders erstellen -- ######");
		System.out.println();
		
		OrderVO order1 = new OrderVO();
		order1.setCustomer(martin);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(hawaii);
		order1.addDish(salami);
		
		OrderVO order2 = new OrderVO();
		order2.setTimestampStartedOrder(LocalDateTime.now());
		order2.setCustomer(steffi);
		
		OrderVO order3 = new OrderVO();
		order3.addDish(hawaii);
		
		OrderVO order4 = new OrderVO();
		order4.setTimestampDeliverdOrder(LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40));
		order4.addDish(quadro);
		order4.addDish(salami);
		order4.addDish(salami);
		order4.setCustomer(timo);
		
		OrderVO order5 = new OrderVO(LocalDateTime.now(), jule);
		
		OrderVO[] orders = {order1, order2, order3, order4, order5};
		
		for (OrderVO order : orders) {			 
            System.out.println(order);
        } 
		
		System.out.println("Order von Timo");
		System.out.println(timo.getOrder());
		System.out.println();
		 
		 // Martin klaut Timos Order weil er hungrig ist. 
		 OrderVO martinssorderold = martin.getOrder();
		 OrderVO timosorder = timo.getOrder();
		 System.out.println("Martins alte Order");
		 System.out.println(martinssorderold);
		 timosorder.setCustomer(martin);
		 System.out.println("Order von Timo sollte null sein weil geklaut bei martin");
		 System.out.println(timo.getOrder());
		 System.out.println("Martin mit Timos Order");
		 System.out.println(martin);
		 System.out.println();
		 System.out.println("Martin Order die er nicht mehr kennt");
		 System.out.println(martinssorderold);
		 
		System.out.println(salami.getClass().getName());
		System.out.println("####### --  Menu -- ######");
		System.out.println();
			
		MenuVO menu = new MenuVO();
		System.out.println(menu);
	}

}
