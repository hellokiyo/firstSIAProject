
public class Emp {
	public int id;
	public String email;
	public String phone;
	public String hire_date;
	public String job_id;
	public int salary;
	public String lastName;
	public String countryName;
	public int commission_pct;
	public int department_id;
	public int manager_id;
	

	@Override
	public String toString() {

		return id + "\t" + email + "\t" + phone + "\t" + hire_date + "\t" + job_id + "\t" + salary;
	}

}
