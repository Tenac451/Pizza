
public class DessertVO extends DishVO {

	public DessertVO(int number, String name, float price) {
		super(number, name, price);
	}
	public DessertVO() {
		super();
	}
	
	@Override
	public Object clone() {
		DessertVO cloneObj = new DessertVO(
				this.getNumber(),
				this.getName(),
				this.getPrice()
				);
		return cloneObj;
	}
	
	@Override
	public String getNameOfDish() {
		return  this.getName();
	}

	@Override
	public int getNumberOfDish() {
		return this.getNumber();
	}

}
