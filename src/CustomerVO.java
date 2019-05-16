import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Jan Münchberger
 *
 */

public class CustomerVO extends PersonVO {

	private String gender;

	private static int nextId = 0;

	private int id;

	private OrderVO order; // #TODO Im UML als orderVO beschrieben

	static final String M = "männlich";
	static final String W = "weiblich";
	static final String N = "";
	static final String D = "divers";

	private LocalDate dateOfBirth;

	public CustomerVO(String lastName, String firstName, String gender, LocalDate dateOfBirth) {
		this(lastName, firstName, null, 0, gender, dateOfBirth);

	}

	public CustomerVO(String lastName, String firstName, LocalDate dateOfBirth) {
		this(lastName, firstName, CustomerVO.N, dateOfBirth);
	}

	public CustomerVO() {
		this("Mampf", "Martin", LocalDate.of(1990, 5, 24));
	}

	public CustomerVO(String lastName, String firstName, String street, int houseNumber, String gender, LocalDate dob) {
		super(lastName, firstName, street, houseNumber);
		this.setDateOfBirth(dob);
		this.setGender(gender);
		this.id = CustomerVO.nextId;
		this.setOrder(null);
		CustomerVO.nextId = CustomerVO.nextId + 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerVO other = (CustomerVO) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	private String dobToString() {
		String result = "";
		result = this.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd MM yyyy"));
		return result;
	}

	public short calculateAge() {
		short age = -1;
		if (this.dateOfBirth == null) {
			return (short) -1;
		}
		int diff = Period.between(this.getDateOfBirth(), LocalDate.now()).getYears();
		if (diff < 32767) {
			age = (short) diff;
		}
		return age;
	}

	public String toString() {
		return "ID: " + this.getId() + '\n' + super.toString() + "Alter: " + calculateAge() + " \nBestelltung:"
				+ this.hasOrder();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		if (dateOfBirth != null) {
			return dateOfBirth;
		} else {
			return null;
		}

	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		if (dateOfBirth != null) {
			int diff = Period.between(dateOfBirth, LocalDate.now()).getYears();
			if (diff > 17) {
				this.dateOfBirth = dateOfBirth;
			} else {
				this.dateOfBirth = null;
			}
		} else {
			this.dateOfBirth = null;
		}
	}

	public int getId() {
		return id;
	}

	public static int getNextId() {
		return nextId;
	}

	public OrderVO getOrder() {
		return this.order;
	}

	public void setOrder(OrderVO order) {
//		if (this.order != null) {
//			this.order.setCustomer(null);
//		}
		this.order = order;
	}

	public boolean hasOrder() {
		if (this.getOrder() != null) {
			return true;
		}
		return false;
	}

}
