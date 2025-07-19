
public class Emp {
	public int employeeId;
	public String firstName;
	public String lastName;
<<<<<<< HEAD
	public String countryName;
	public int manager_id;
	public int department_id;
	public int commission;
	@Override
	public String toString() {
		return "Emp [id=" + id + ", email=" + email + ", phone=" + phone + ", hire_date=" + hire_date + ", job_id="
				+ job_id + ", salary=" + salary + ", lastName=" + lastName + ", countryName=" + countryName
				+ ", manager_id=" + manager_id + ", department_id="
				+ department_id + ", commission=" + commission + "]";
=======
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
>>>>>>> a8eb41af6499edacc4bece3b57236b69f338b6c3
	}

}
