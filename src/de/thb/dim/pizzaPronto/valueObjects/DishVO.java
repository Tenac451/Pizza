package de.thb.dim.pizzaPronto.valueObjects;
import java.text.DecimalFormat;
import java.util.Arrays;


public abstract class DishVO implements Comparable<DishVO>, Cloneable{
	protected int number;
	protected String name;
	protected String[] ingredients;
	protected float price;

	
	public DishVO(int number, String name, String[] ingredients, float price) {
		setNumber(number);
		setName(name);
		setPrice(price);
		setIngredients(ingredients);
	}

	
	public DishVO(int number, String name, float price) {
		this(number, name, null, price);
	}

	
	public DishVO() {
		this(0, null, null, 0.00f);
	}

	/**
	 * see exercise later
	 * 
	 */
	public Object clone() throws InternalError {
		Object other = null;
		try {
			other = super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
		return other;
	}

	
	public String toString() {
		DecimalFormat dFormat = new DecimalFormat(".00"); // Formatierung der
															// Preisangabe ...
		StringBuffer sb = new StringBuffer(); // R�ckgabewert ...

		sb.append(getNumberOfDish() + " - ");
		sb.append(getNameOfDish() + "\t");

		sb.append(ingredientsToString());

		sb.append("\n\tPrice:\t\t\t" + dFormat.format(getPrice()) + " Euro");
		sb.append("\n");

		return sb.toString();
	}

	
	public String ingredientsToString() {
		StringBuffer sb = new StringBuffer();

		if (getIngredients() != null) { // Wenn Zutaten Array nicht
			// null ...
			for (String currentIngredient : getIngredients()) { // F�r jede
				// Zutat ...
				sb.append(currentIngredient + ", "); // aktuelle Zutat und Komma an
				// R�ckgabestring anh�ngen ...
			}
			sb = new StringBuffer(sb.substring(0, sb.length() - 2)); // Komma am Ende entfernen ...
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + Arrays.hashCode(ingredients);
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
		DishVO other = (DishVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (!Arrays.equals(ingredients, other.ingredients))
			return false;
		return true;
	}

	// /
	// / Setter und Getter
	// /
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] zutaten) {
		this.ingredients = zutaten;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = (price > 0f) ? price : 0f;
	}

	/**
	 * Abstract method of returning the name of the dish as in menu. Must be overridden by the derived classes.
	 * 
	 * @return - name of the dish
	 */
	public abstract String getNameOfDish();

	/**
	  * Abstract method of returning the number of the dish as in menu. Must be overridden by the derived classes.
	 * 
	 * @return - number of the dish
	 */
	public abstract int getNumberOfDish();
	
	public int getNumberofDish() {
		return getNumberOfDish();
	}
	public int compareTo(DishVO o) {
		return this.getNameOfDish().compareTo(o.getNameOfDish());
	}

} 
