package de.thb.dim.pizzaPronto.valueObjects.exceptions;

public class CustomerTooYoungException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -754057581204546389L;
	
	public CustomerTooYoungException () {
		super();
	}
	public CustomerTooYoungException (String message) {
		super(message);
	}

}
