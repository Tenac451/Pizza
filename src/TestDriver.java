import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class TestDriver {

	public static void main(String[] args) {
		CustomerVO jule = new CustomerVO("Jule", "Hansen", CustomerVO.W, LocalDate.of(1990, 5, 24));
		
		
		OrderVO order3 = new OrderVO(LocalDateTime.now(), jule);
		OrderVO order = new OrderVO();
		OrderVO order2 = new OrderVO();
		
		
		OrderVO order4 = new OrderVO(LocalDateTime.now(), jule);
		
		//System.out.println(order);
		
		order.setTimestampStartedOrder(LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40));
		order.setTimestampDeliverdOrder(LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40));
//		
//		System.out.println(order);
//		System.out.println(order2);
//		System.out.println(order3);
//		System.out.println(order4);
//		
		//LocalDateTime today = LocalDateTime.now();
		//System.out.println(today);
		
		
		
//		
//		ChefVO bocuse = new ChefVO("Bocuse", "Brune", Color.RED);
//		ChefVO bocuse2 = new ChefVO("Bocuse", "Peter", Color.RED);
//		System.out.println(bocuse.getLastName());
//		PizzaVO salami1 = new PizzaVO();
//	
		String[] zutaten2 =  {"Salami" ,"Gauda"};
		PizzaVO salami2= new PizzaVO("Salami", zutaten2, 2.50f);
//		
		String[] zutaten3 =  {"Salami" ,"Käse", "Tomaten"};
		PizzaVO salami3 = new PizzaVO("Salami", zutaten3, 2.50f);
		
		order4.addDish(salami3);
//		order4.addDish(salami2);
//		order4.addDish(salami3);
		
		System.out.println(order4);
		
		//order4.deleteDish();
		System.out.println(order4);
		
		System.out.println(order4.getDish(10));
		
		System.out.println(order4.getNumerOfDishes());
		
		System.out.println(jule);
//		PizzaVO salami4 = (PizzaVO) salami3.clone();
//		
//		LocalDate today = LocalDate.now();
//		LocalDate dob = LocalDate.of(1700, 5, 24);
//		
//		CustomerVO martin = new CustomerVO();
//		CustomerVO timo = new CustomerVO("Timo", "Hansen", CustomerVO.M, dob);
//		CustomerVO jule = new CustomerVO("Jule", "Hansen", CustomerVO.W, LocalDate.of(1998, 5, 24));
//		CustomerVO kirsten = new CustomerVO("Kirsten", "Hansen", CustomerVO.D, LocalDate.of(1980, 5, 21));
//		CustomerVO stefan = new CustomerVO("Stefan", "Hansen", LocalDate.of(2005, 1, 1));


		
//		System.out.println("###### toStrings #######");
//		System.out.println(bocuse);
//		System.out.println(bocuse2);
//		System.out.println(timo);
//		System.out.println(martin);
//		System.out.println(stefan);
//		System.out.println(kirsten);
//		System.out.println(jule);
//		System.out.println(salami1);
//		System.out.println(salami2);
//		System.out.println(salami3);
//		System.out.println(salami4);
//
//		
//		System.out.println("###### hashCodes #######");
//		System.out.println("HashCode Bocuse: " + bocuse.hashCode());
//		System.out.println("HashCode Bocuse2: " + bocuse2.hashCode());
//		System.out.println("HashCode Timo: " + timo.hashCode());
//		System.out.println("HashCode Stefan: " + stefan.hashCode());
//		System.out.println("HashCode Kirsten: " + kirsten.hashCode());
//		System.out.println("HashCode Jule: " + jule.hashCode());
//		System.out.println("HashCode Martin: " + martin.hashCode());
//		System.out.println("HashCode Salami: " + salami1.hashCode());
//		System.out.println("HashCode Salami2: " + salami2.hashCode());
//		System.out.println("HashCode Salami3: " + salami3.hashCode());
//		System.out.println("HashCode Salami4: " + salami4.hashCode());
//		
//		System.out.println("###### equals #######");
//		System.out.println("equals Salami3 u 4: " + salami4.equals(salami3));
//		System.out.println("equals Salami4 u 3: " + salami3.equals(salami4));
//		System.out.println("equals Salami1 u 3: " + salami1.equals(salami3));
//		System.out.println("equals Salami1 u Timo: " + salami1.equals(timo));
	}

}
