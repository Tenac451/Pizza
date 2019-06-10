package de.thb.dim.pizzaPronto.valueObjects;

import java.io.Serializable;

/**
 * PersonVO is teh superclass containing basic attributes
 * 
 * @author Gabrile Schmidt
 *  * @version 1.0
 * @since 27.05.2018
 *
 */

abstract class PersonVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2046410791062860526L;
	protected String lastName;
	protected String firstName;
	protected String street;
	protected int houseNumber;
	
	public PersonVO(String lastName, String firstName, String street, int houseNumber) {
		setLastName(lastName);
		setFirstName(firstName);
		setStreet(street);
		setHouseNumber(houseNumber);
	}
	
	public PersonVO(String lastName, String firstName){
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
	
	public boolean equals(Object obj) {
		boolean isEqual = false;
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		if (this.getClass() == obj.getClass()){
			PersonVO other = (PersonVO) obj;
			isEqual = (	other.getFirstName().equals(firstName) && 
						other.getLastName().equals(lastName) &&
						other.getStreet().equals(street) &&
						other.getHouseNumber() == houseNumber);
		}
		
		return isEqual;
	}
	
	public int hashCode() {
		int hc = 0;
		final int hashMultiplier = 59;
		
		if (firstName != null) {
			hc = firstName.hashCode();
		}
		if (lastName != null) {
			hc = hc * hashMultiplier + lastName.hashCode();
		}
		
		if (street != null) {
			hc = hc * hashMultiplier + street.hashCode();
		}

		hc = hc * hashMultiplier + houseNumber;
		
		return hc;
	}
	
	public String toString(){
		return String.format("Name: %s %s\n\tStreet: %s %d\n", firstName, lastName, street,houseNumber);
	}
}
