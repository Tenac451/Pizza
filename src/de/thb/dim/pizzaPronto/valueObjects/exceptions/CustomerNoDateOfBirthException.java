package de.thb.dim.pizzaPronto.valueObjects.exceptions;

public class CustomerNoDateOfBirthException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2035469193041803702L;
	
	public CustomerNoDateOfBirthException () {
		super();
	}
	public CustomerNoDateOfBirthException (String message) {
		super(message);
	}
}
