import java.util.Arrays;

abstract class DishVO {

	protected int number;
	protected String name;
	protected String[] ingredients;
	protected float price;

	public DishVO(int number, String name, String[] ingredients, float price) {
		this.setNumber(number);
		this.setName(name);
		this.setIngredients(ingredients);
		this.setPrice(price);
	}

	public DishVO(int number, String name, float price) {
		this(number, name, new String[0], price);
	}

	public DishVO() {
		this(0, null, 0.0f);
	}

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

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if (price > 0.0f) {
			this.price = price;
		} else {
			this.price = 0.0f;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + Float.floatToIntBits(price);
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
		if (!Arrays.equals(ingredients, other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

//	public Object clone() {
//		return new Object();
//	}
	public String ingredientsToString() {
		if(this.ingredients != null) {
			return String.join(", ", this.ingredients);
		}
		return "";
		
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.getNumberOfDish());
		result.append("\t-\t");
		result.append(this.getNameOfDish());
		result.append(", ");
		result.append(this.getPrice());
		result.append("\n\t\t");
		result.append(this.ingredientsToString());
		return result.toString();
	}

	public abstract String getNameOfDish();

	public abstract int getNumberOfDish();

}
