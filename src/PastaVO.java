
public class PastaVO extends DishVO {
	private int typeOfPasta;

	public PastaVO(int number, String name, String[] ingredients, float price, int pastaType) {
		super(number, name, ingredients, price);
		this.setTypeOfPasta(pastaType);
	}

	public PastaVO() {
		this(0, null, null, 0.0f, 0);
	}

	@Override
	public Object clone() {
		PastaVO cloneObj = new PastaVO(this.getNumber(), this.getName(), this.getIngredients(), this.getPrice(),
				this.getTypeOfPasta());
		return cloneObj;
	}

	@Override
	public String getNameOfDish() {
		return "Pasta " + this.getName() + " - " + this.getTypeOfPastaString();
	}

	@Override
	public int getNumberOfDish() {
		return this.getNumber() + (this.getTypeOfPasta() * 100);
	}

	public int getTypeOfPasta() {
		return typeOfPasta;
	}

	public void setTypeOfPasta(int typeOfPasta) {
		this.typeOfPasta = typeOfPasta;
	}

	public String getTypeOfPastaString() {
		switch (this.getTypeOfPasta()) {
		case 4:
			return "Spaghetti";
		case 5:
			return "Tortellini";
		case 6:
			return "Gnocchi";
		default:
			return "Standard";
		}
	}

}
