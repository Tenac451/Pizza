import java.awt.Color;
import java.time.LocalDate;

public class TestDriver {

	public static void main(String[] args) {
		
		ChefVO bocuse= new ChefVO("Bocuse", "Brune", Color.RED);
		System.out.println(bocuse.getLastName());
		
		
		LocalDate today = LocalDate.now();
		LocalDate dob = LocalDate.of(1990, 5, 24);
		
		CustomerVO martin = new CustomerVO();
		System.out.println(martin);
		System.out.println(martin.dobToString());
		
		CustomerVO timo = new CustomerVO("Timo", "Hansen", CustomerVO.M, dob);
		System.out.println(timo);
		System.out.println(today);
		System.out.println(dob);
		System.out.println(timo.dobToString());
	}

}
