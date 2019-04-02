import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Jan Münchberger
 *
 */

public class CustomerVO {
	
	private String lastName;
	
	private String firstName;
	
	private String gender;
	
	static final String M = "männlich";
	static final String W = "weiblich";
	static final String D = "divers";
	
	private LocalDate dateOfBirth;
	
	public CustomerVO(String lastName, String firstName, String gender, LocalDate dateOfBirth) {
		super();
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setGender(gender);
		this.setDateOfBirth(dateOfBirth);
	}
	
	public CustomerVO(String lastName, String firstName, LocalDate dateOfBirth) {
		super();
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setDateOfBirth(dateOfBirth);
	}
	
	public CustomerVO() {
		this("Mampf", "Martin", LocalDate.of(1990, 5, 24));
	}
	
	
	public String dobToString() {
		String result = "";
		
		//result = this.getDateOfBirth().toString();
		result = this.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd MM yyyy"));
		return result;
	}
	public String toString() {
		return this.getFirstName() + ' ' + this.getLastName();
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
