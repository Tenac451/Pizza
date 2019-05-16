
public class DeliveryManVO extends EmployeeVO {
	private String driverLicence;

	DeliveryManVO(String personnelNo, String lastName, String firstName) {
		super(personnelNo, lastName, firstName);
	}

	DeliveryManVO() {
		this(null, null, null);
	}

	@Override
	public String toString() {
		return "Delivery Man:\nDeliveryMan_" + super.toString();
	}

	public String getDriverLicence() {
		return driverLicence;
	}

	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}
}
