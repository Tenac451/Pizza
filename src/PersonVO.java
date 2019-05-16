
public abstract class PersonVO {

	protected String lastName;
	protected String firstName;
	protected String street;
	protected int houseNumber;

	public PersonVO(String lastName, String firstName, String street, int houseNumber) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setStreet(street);
		this.setHouseNumber(houseNumber);
	}

	public PersonVO(String lastName, String firstName) {
		this(lastName, firstName, null, 0);
	}

	public PersonVO() {
		this(null, null);
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + houseNumber;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		PersonVO other = (PersonVO) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (houseNumber != other.houseNumber)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Name: " + this.getFirstName() + " " + this.getLastName() + "\n" + "Straße: " + this.getStreet() + " "
				+ this.getHouseNumber() + "\n";
	}

}
