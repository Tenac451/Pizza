import java.util.Arrays;

/**
 * 
 * @author Jan Münchberger
 *
 */

public class PizzaVO {
	
	private String name;
	
	private float price;
	
	private String[] ingredients;
	
	public PizzaVO(String name, String[] ingredients, float price) {
		super();
		this.setName(name);
		this.setPrice(price);
		this.setIngredients(ingredients);
		
	}

	public PizzaVO() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		PizzaVO other = (PizzaVO) obj;
		if (!Arrays.equals(ingredients, other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}
	
	@Override
	public Object clone() {
		PizzaVO cloneObj = new PizzaVO(this.getName(),this.getIngredients(),this.getPrice());
		return cloneObj;	
	}
	
	public String toString() {
		return this.getName();
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
		if(price > 0.0f) {
			this.price = price;
		} else {
			this.price = 0.0f;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
