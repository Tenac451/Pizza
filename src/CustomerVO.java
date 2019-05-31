import java.time.LocalDate;
import java.time.Period;
//import java.time.format.DateTimeFormatter;

/**
 * CustomerVO represents objects of customer.
 * @author Robert Fischer, Gabriele Schmidt
 * @version 2.0
 *
 */
public class CustomerVO  extends PersonVO{
	
	private static int nextId = 0;
	private int id;

	
	private String gender;
	private LocalDate dateOfBirth;
	
	private OrderVO order;
	
	/**
	 * initializing constructor
	 * Initialize all instance attributes with values. 
	 * 
	 * @param lastName - Customer's second name
	 * @param firstName - Customer's first name
	 * @param street - Customer's street
	 * @param houseNumber - Customer's house number
	 * @param gender - Customer's gender
	 * @param dateOfBirth - Customer's date of birth
	
	 */
	public CustomerVO(String lastName, String firstName, String street, int houseNumber, String gender, LocalDate dob) {
		super(lastName, firstName, street, houseNumber);
		id = nextId;
		nextId++;
		setGender(gender);
		setDateOfBirth(dob);
		setOrder(order);

	}
	
	

	/**
	 * initializing constructor
	 * Initialize all instance attributes with values. 
	 * 
	 * @param lastName - Customer's second name
	 * @param firstName - Customer's first name
	 * @param dateOfBirth - Customer's date of birth
	 * 
	 */
	public CustomerVO(String lastName, String firstName, LocalDate dob) {
		this(lastName, firstName, null, 0, null, dob);

	}
	
	

	/**
	 * default constructor 
	 * calls initializing constructor with default values for instance attributes
	 * 
	 */
	public CustomerVO() {
		this(null, null, null);
		
	}
	
	/**
	 * The customer's age is calculated. There is no instance variable.
	 * 
	 * @return age - short
	 */
	public short calculateAge() {
		short alter = -1;
		Period age;
		LocalDate today = LocalDate.now();

		if (dateOfBirth != null) {
			age = Period.between(dateOfBirth, today);
			alter = (short) age.getYears();
		}
		return alter;
	}
	
	/**
	 * Checks whether there is a current order or not
	 * 
	 * @return true => order available, false => there is no order
	 * 
	 */
	public boolean hasOrder() {
		if (order != null) return true;
		else return false;
	}
	
	
	

	// standards Method of Java
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// if (!(obj instanceof KundeVO))
		// return false;
		// instanceof is unknown yet -> inheritance
		// This is a weak check, sind obj would also be an instance of its superclasses
		// which doesn't correspnds wit hthe contract of equals:
		// if x.equals(y) [is true] then (x.hashCode() == y.hashCode()) is true too.

		// better solution
		if (getClass() != obj.getClass()) {
			return false;
		}

		CustomerVO other = (CustomerVO) obj;
		if (id != other.getId()) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		int hc = 0;
		final int hashMultiplier = 59;
		hc = hashMultiplier * id;

		return hc;
	}

	public String toString() {
		return String.format("Customer:\n" + "\tId: %d\n" + 
				"\t%s"
				+ "\tGender: %s\n" + "\tDate of Birth: %s\n" + "\tAge: %d\n"
						+ "\thas a current order: %b",
				this.getId(), super.toString(),
				this.getGender(), this.getDateOfBirth(),
				this.calculateAge(),
				hasOrder());
	}
	
	/**
	 * Returns the birth date in human-readable form.
	 * 
	 * @return - the complete string
	 *  
	 */
//	private String dobToString() {
//		return dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MMM.yyyy"));
//	}
//	
	
	//Setter and Getter
	public static int getNextId() {
		return nextId;
	}
	
	public int getId() {
		return id;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * older than 17 years
	 * 
	 * @param dateOfBirth
	 *        -     java.time.LocalDate
	 */
	public void setDateOfBirth(LocalDate dob) {
		this.dateOfBirth = dob;
		if (this.calculateAge() < 18)
			this.dateOfBirth = null;
	}
	
	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO orderVO) {
		this.order = orderVO;
	}
	

	
} // end of class