
/**
 * EmployeeVO represents an object of employee 
 * 
 */
public abstract class EmployeeVO extends PersonVO {
	protected String personnelNo;
	protected float salary;
	protected int vacationDays;
	
	
	public EmployeeVO(String personnelNo, String lastName, String firstName) {
		super(lastName, firstName);
		setPersonnelNo(personnelNo);
	}

	
	public EmployeeVO() {
		this(null, null, null);
	}

	
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(getPersonnelNo() + " ");

		sb.append(super.toString());

		sb.append("\tSalary: " + getSalary() + "\n");
		sb.append("\tNumber of vacation days: " + getVacationDays());

		return sb.toString();
	}



	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EmployeeVO other = (EmployeeVO) obj;
		if (!personnelNo.equals(other.getPersonnelNo())) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		return personnelNo.hashCode();
	}

	//
	// Setter und Getter
	//
	
	public String getPersonnelNo() {
		return personnelNo;
	}

	public void setPersonnelNo(String personnelNo) {
		this.personnelNo = personnelNo;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
} 
