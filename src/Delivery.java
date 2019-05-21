import java.util.Random;

public class Delivery implements IService {
	private EmployeeVO[] employees;

	public Delivery() {
		employees = new EmployeeVO[2];
		employees[0] = new DeliveryManVO();
		employees[1] = new DeliveryManVO();
	}

	@Override
	public String startService(OrderVO order) {
		
		EmployeeVO employee = selectEmployee();
		CustomerVO customer = null;
		if (order != null) {
			customer = order.getCustomer();
		} else {
			return "No order available.";
		}
			
		if (customer == null) {
			return String.format(" Service if DeliveryManVO %s: No customer available. ", employee.getFirstName() + " " + employee.getLastName());
		}
		if ("ready".equals(order.getState())) {
			order.setState("delivered");
			return String.format(" Service if DeliveryManVO %s:  Order is delivered on ", employee.getFirstName() + " " + employee.getLastName());
		}
		return String.format(" Service of DeliveryManVO %s: No order is ready for processing. available. ", employee.getFirstName() + " " + employee.getLastName());
	}

	private EmployeeVO selectEmployee() {
		Random zufall = new Random();
		return employees[zufall.nextInt(2)];
	}
	
	public EmployeeVO[] getEmployees() {
		return employees;
	}
}
