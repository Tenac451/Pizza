import java.awt.Color;

/**
 * 
 * @author Jan M�nchberger
 *
 */

public class ChefVO extends EmployeeVO {

	private Color colorApron;

	public ChefVO(String personnelNo, String lastName, String firstName) {
		super(personnelNo, lastName, firstName);
		this.setColorApron(Color.BLUE);
	}

	public ChefVO(String lastName, String firstName, Color colorApron) {
		this(null, lastName, firstName);
		this.setColorApron(colorApron);
	}

	public ChefVO() {
		this("Bocuse", "Bruno", Color.BLUE);
	}

	public String toString() {
		return "Chef :\nChef_" + super.toString() + "" + "Apron:" + this.getColorApron() + "\n";
	}

	public Color getColorApron() {
		return colorApron;
	}

	public void setColorApron(Color colorApron) {
		this.colorApron = colorApron;
	}

}
