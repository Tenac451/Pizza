package de.thb.dim.pizzaPronto.businessObjects.exceptions;

public class NoOrderException  extends Exception{

	private static final long serialVersionUID = -5703475600782560038L;
	
	public NoOrderException () {
		super();
	}
	
	public NoOrderException (String message) {
		super(message);
	}
}
