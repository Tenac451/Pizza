package de.thb.dim.pizzaPronto.businessObjects.exceptions;

public class NoCustomerException extends Exception {

	private static final long serialVersionUID = 4871063315152098597L;

	public NoCustomerException() {
		super();
	}

	public NoCustomerException(String message) {
		super(message);
	}
}
