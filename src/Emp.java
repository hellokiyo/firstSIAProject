
public class Emp {
	public int id;
	public String email;
	public String phone;
	public String hire_date;
	public String job_id;
	public int salary;
	public String lastName;
	public String countryName;
	
	@Override
	public String toString() {
		return "id=" + id + " email=" + email + ", phone=" + phone + ", hire_date=" + hire_date + ", job_id="
				+ job_id + ", salary=" + salary + ", lastName=" + lastName + ", countryName=" + countryName;
	}
	
	
}
