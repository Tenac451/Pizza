import java.awt.Color;

/**
 * 
 * @author Jan Münchberger
 *
 */

public class ChefVO {
	
	private String lastName;
	private String firstName;
	private Color colorApron;
	
	
	public ChefVO(String lastName, String firstName, Color colorApron) {
		super();
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setColorApron(colorApron);
	}
	
	public ChefVO() {
		this("Bocuse", "Bruno", Color.BLUE);
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Color getColorApron() {
		return colorApron;
	}
	public void setColorApron(Color colorApron) {
		this.colorApron = colorApron;
	}

}
