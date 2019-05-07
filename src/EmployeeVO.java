
public class EmployeeVO extends PersonVO {
	protected String personnelNo;
	protected float salary;
	protected int vacationDays;

	public EmployeeVO(String personnenlNo, String lastName, String firstName) {
		super(lastName, firstName, null, 0);
		this.personnelNo = personnenlNo;
		this.salary = 1200.5f;
		this.vacationDays = 26;
	}
	public EmployeeVO() {
		this(null,null,null);
	}
	
	public String getPersonnelNo() {
		return personnelNo;
	}
	public void setPersonnelNo(String personnelNo) {
		this.personnelNo = personnelNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((personnelNo == null) ? 0 : personnelNo.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		result = prime * result + vacationDays;
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
		EmployeeVO other = (EmployeeVO) obj;
		if (personnelNo == null) {
			if (other.personnelNo != null)
				return false;
		} else if (!personnelNo.equals(other.personnelNo))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		if (vacationDays != other.vacationDays)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return personnelNo + "  " + super.toString() + "Salary: " + salary + "\nNumber of vacation days: " + vacationDays + "\n" ;
	}
	
}
