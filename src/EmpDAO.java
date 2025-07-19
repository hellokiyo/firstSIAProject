import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class EmpDAO {

	public static List<Emp> getDeptHeadFistName(String getFirstName) throws Exception {

		List<Emp> result = new ArrayList<Emp>();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		String sql = "select * from employees e join departments d on e.department_id = d.department_id where e.first_name = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, getFirstName);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.email = rs.getString("email");
			emp.phone = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;
	}

	public static List<Emp> getEmpListByCountryName(String cityName) throws Exception {

		System.out.println("나라 이름 : ");
		Scanner scan = new Scanner(System.in);
		String countryName = scan.nextLine();

		// 나라 이름으로 그 나라에 근무하는 직원을 조회할 수 있는가
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "select c.country_name, e.employee_id, e.last_name, e.phone_number, e.salary\r\n"
				+ "from employees e\r\n" + "	join departments d on e.department_id = d.department_id\r\n"
				+ "	join locations l on l.location_id = d.location_id\r\n"
				+ "	join countries c on c.country_id = l.country_id " + " where c.country_name = '" + cityName + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.phone = rs.getString("phone_number");
			emp.salary = rs.getInt("salary");
			emp.countryName = rs.getString("country_name");
			result.add(emp);
		}

		return result;

	}

	public static Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		// 직원 이름으로 직원정보를검색할 수 있는가?

		// 나라 이름으로 그 나라에 근무하는 직원을 조회할 수 있는가
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "select c.country_name, e.employee_id, e.last_name, e.phone_number, e.salary\r\n"
				+ "from employees e\r\n" + "	join departments d on e.department_id = d.department_id\r\n"
				+ "	join locations l on l.location_id = d.location_id\r\n"
				+ "	join countries c on c.country_id = l.country_id " + " where c.country_name = '" + cityName + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.phone = rs.getString("phone_number");
			emp.salary = rs.getInt("salary");
			emp.countryName = rs.getString("country_name");
			result.add(emp);
		}

		return result;

	}

	public static Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		// 직원 이름으로 직원정보를검색할 수 있는가?

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		String sql = "select * from employees where first_name = ? and last_name = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);

		ResultSet rs = stmt.executeQuery();
		Emp emp = new Emp();

		while (rs.next()) {
			emp.id = rs.getInt("employee_id");
			emp.email = rs.getString("email");
			emp.phone = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary = rs.getInt("salary");

		}
		return emp;

	}

//입사년도로 검색할 수 있는가?
	public static List<Emp> getEmpListByYear(int year) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		Statement stmt = conn.createStatement();
		String sql = "select * from employees where YEAR(hire_date) = " + year;
		System.out.println("SQL: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.id = rs.getInt("employee_id");
			emp.email = rs.getString("email");
			emp.phone = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;

	}

//부서번호로 검색할 수 있는가?
	public static List<Emp> getEmpListBydepId(int depId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		Statement stmt = conn.createStatement();
		String sql = "select * from employees where department_id =" + depId;
		System.out.println("SQL: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.id = rs.getInt("employee_id");
			emp.email = rs.getString("email");
			emp.phone = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;
	}

//직무로 검색가능한가?
	public static List<Emp> getEmpListByjobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM employees WHERE job_id = '" + jobId + "'";
		System.out.println("SQL: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.id = rs.getInt("employee_id");
			emp.email = rs.getString("email");
			emp.phone = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;

	}

	// 도시이름으로 검색가능한가?
	public static List<Emp> getEmpListBycityId(String cityId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		Statement stmt = conn.createStatement();
		String sql = "SELECT e.employee_id, e.email, e.phone_number, e.hire_date, e.job_id, e.salary "
				+ "FROM employees e " + "JOIN departments d ON e.department_id = d.department_id "
				+ "JOIN locations l ON d.location_id = l.location_id " + "WHERE l.city = '" + cityId + "'";
		System.out.println("SQL: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.email = rs.getString("email");
			emp.phone = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission_pct = rs.getInt("commission_pct");
			emp.manager_id = rs.getInt("manager_id");
			emp.department_id = rs.getInt("department_id");

			result.add(emp);
		}
		return result;
	}

	public static List<Emp> getEmpListByCountryName(String cityName) throws Exception {

		// 나라 이름으로 그 나라에 근무하는 직원을 조회할 수 있는가
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		Statement stmt = conn.createStatement();
		String sql = "select c.country_name, e.employee_id, e.last_name, e.phone_number, e.salary\r\n"
				+ "from employees e\r\n" + "	join departments d on e.department_id = d.department_id\r\n"
				+ "	join locations l on l.location_id = d.location_id\r\n"
				+ "	join countries c on c.country_id = l.country_id " + " where c.country_name = '" + cityName + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.phone = rs.getString("phone_number");
			emp.salary = rs.getInt("salary");
			emp.countryName = rs.getString("country_name");
			result.add(emp);
		}

		return result;

	}

	public static Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		// 직원 이름으로 직원정보를검색할 수 있는가?

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/newhr", "root", "rootroot");

		String sql = "select * from employees where first_name = ? and last_name = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);

		ResultSet rs = stmt.executeQuery();
		Emp emp = new Emp();

		while (rs.next()) {
			emp.id = rs.getInt("employee_id");
			emp.email = rs.getString("email");
			emp.phone = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getInt("commission_pct");
			emp.manager_id = rs.getInt("manager_id");
			emp.department_id = rs.getInt("department_id");

		}
		return emp;

	}

//입사년도로 검색할 수 있는가?
public static List<Emp> getEmpListByYear(int year) throws Exception {
	List<Emp> result = new ArrayList<Emp>();
	Connection conn = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
	
	Statement stmt = conn.createStatement();
	String sql = "select * from employees where YEAR(hire_date) = " + year;
	System.out.println("SQL: " + sql);
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()) {
		Emp emp = new Emp();
		emp.id = rs.getInt("employee_id");
		emp.id = rs.getInt("employee_id");
		emp.email = rs.getString("email");
		emp.phone = rs.getString("phone_number");
		emp.hire_date = rs.getString("hire_date");
		emp.job_id = rs.getString("job_id");
		emp.salary = rs.getInt("salary");
		result.add(emp);
	}
	return result;
}
