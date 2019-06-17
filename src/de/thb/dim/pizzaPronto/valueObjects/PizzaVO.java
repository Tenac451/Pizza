package de.thb.dim.pizzaPronto.valueObjects;

public class PizzaVO extends DishVO {
	private int size;

	/**
	 * initializing constructor Initialize all instance attributes with values.
	 * 
	 * @param name        - Name of the pizza
	 * @param ingredients - ingredients of the pizza
	 * @param price       - price of the pizza
	 * 
	 */
	public PizzaVO(int number, String name, String[] ingredients, float price, int size) {
		super(number, name, ingredients, price);
		setSize(size);
	}

	public PizzaVO(int number, String name, String[] ingredients, float price) {
		this(number, name, ingredients, price, 1);

	}

	/**
	 * default constructor calls initializing constructor with default values for
	 * instance attributes
	 * 
	 */
	public PizzaVO() {
		this(0, null, null, 0.0f);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaVO other = (PizzaVO) obj;
		if (size != other.size)
			return false;
		return true;
	}

	/**
	 * 10.1
	 * 
	 */
	public Object clone() throws InternalError {
		return super.clone();
	}

	@Override
	public String getNameOfDish() {
		StringBuffer sb = new StringBuffer();
		sb.append("Pizza " + getName());

		if (size == 1)
			sb.append(" - Normal");
		else
			sb.append(" - Grande");

		return sb.toString();
	}

	@Override
	public int getNumberOfDish() {
		return this.number * 10 + this.size;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
