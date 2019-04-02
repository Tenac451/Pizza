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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colorApron == null) ? 0 : colorApron.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		ChefVO other = (ChefVO) obj;
		if (colorApron == null) {
			if (other.colorApron != null)
				return false;
		} else if (!colorApron.equals(other.colorApron))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	public String toString() {
		return this.getFirstName() + ' ' + this.getLastName();
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
