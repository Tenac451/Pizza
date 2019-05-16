
public class Kitchen implements IService {
	private EmployeeVO[] employees;

	public Kitchen() {
		employees = new EmployeeVO[1];
		employees[0] = new ChefVO();
	}

	@Override
	public String startService(OrderVO order) {
		if (order == null) {
			return String.format(" Service if ChefVO %s: No order available. ", employees[0].getFirstName() + " " + employees[0].getLastName());
		}
		if ("confirmed".equals(order.getState())) {
			order.setState("ready");
			return String.format(" Service if ChefVO %s: Order is ready ", employees[0].getFirstName() + " " + employees[0].getLastName());
		}
		return String.format("Serivce of ChefVO %s: No order for processing available. ", employees[0].getFirstName() + " " + employees[0].getLastName() );
	}

}
