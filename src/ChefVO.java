import java.awt.Color;

/**
 * ChefVO represents the objects of chef 
 * @author Robert Fischer, Gabriele Schmidt
 * @version 2.0
 *
 */
public class ChefVO extends EmployeeVO{
	private Color colorApron;
	
	
	public ChefVO(String personnelNo, String lastName, String firstName) {
		super(personnelNo, lastName, firstName);
		colorApron = Color.WHITE;
		vacationDays = 25;
		salary = 2100;
	}
	
	/**
	 * default constructor 
	 * calls initializing constructor with default values for instance attributes
	 * 
	 */
	public ChefVO() {
		this(null, null, null);
	}
	
	
	//Standard methode of Java
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("\nChef:\n" );
		
		sb.append(super.toString());
		
		sb.append("\nApron " + colorApron.toString());
		
		return sb.toString();
	}

	/// 
	/// Setter und Getter
	///

	public Color getColorApron() {
		return colorApron;
	}

	public void setColorApron(Color colorApron) {
		this.colorApron = colorApron;
	}

	

	
} // End  of class
