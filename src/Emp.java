
public class Emp {
	public int employeeId;
	public String firstName;
	public String lastName;
	public String email;
	public String phoneNo;
	public String hireDate;
	public String jobId;
	public int salary;
	public double commission;
	public int managerId;
	public int departmentId;
	
	@Override
	public String toString() {
		return "Emp [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNo=" + phoneNo + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary=" + salary
				+ ", commission=" + commission + ", managerId=" + managerId + ", departmentId=" + departmentId + "]";
	}

}
