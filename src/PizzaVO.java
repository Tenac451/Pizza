/**
 * 
 * @author Jan Münchberger
 *
 */

public class PizzaVO extends DishVO {

	private int size;
	
	public PizzaVO(int number, String name, String[] ingredients, float price, int size) {
		super(number, name, ingredients, price);
		this.setSize(size);
	}
	public PizzaVO(int number, String name, String[] ingredients, float price) {
		super(number, name, ingredients, price);
		this.setSize(0);
	}

	public PizzaVO() {
		super();
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

	@Override
	public Object clone() {
		PizzaVO cloneObj = new PizzaVO(this.getNumber(),this.getName(),this.getIngredients(),this.getPrice(), this.getSize());
		return cloneObj;	
	}

	@Override
	public String getNameOfDish() {
		return "Pizza " + this.getName()  +" - "+ this.getSizeString();
	}

	@Override
	public int getNumberOfDish() {
		return this.size + (this.number*10);
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSizeString() {
		if(this.getSize() == 1)
			return "Normal";
		if(this.getSize() == 2)
			return "Grande";
		return "Standard";
	}

}
