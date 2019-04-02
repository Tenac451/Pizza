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
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
