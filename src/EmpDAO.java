import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class EmpDAO {
	// 1번 문제 : 직원 이름으로 직원정보를검색할 수 있는가?
	public static Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/newhr", "root", "rootroot");

		PreparedStatement stmt = conn.prepareStatement("getEmpByFirstNLastName");
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);

		ResultSet rs = stmt.executeQuery();

	}
//리턴값 리스트 
	// 2번 문제 : 입사년도로 검색할 수 있는가?
	public static List<Emp> getEmpListByYear(int year) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		stmt.setInt(1, year);
		
		
		
		System.out.println("SQL: " + sql);
		//while
		return result;
	}

	// 3번 문제 부서번호로 검색할 수 있는가?
	public static List<Emp> getEmpListBydepId(int depId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		String sql = "select * from employees where department_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, depId);
		
		
		System.out.println("SQL: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		//while
		return result;
	}

	// 4번 문제 : 직무로 검색가능한가?
	public static List<Emp> getEmpListByjobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		String sql = "SELECT * FROM employees WHERE job_id = '" + jobId + "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, jobId);
		
		System.out.println("SQL: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		//while
		return result;

	}


	// 5번 문제 : 도시이름으로 직원정보 검색
	public static List<Emp> getEmpListBycityId(String cityId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");

		String sql = "SELECT e.employee_id, e.email, e.phone_number, e.hire_date, e.job_id, e.salary "
				+ "FROM employees e " + "JOIN departments d ON e.department_id = d.department_id "
				+ "JOIN locations l ON d.location_id = l.location_id " + "WHERE l.city = '" + cityId + "'";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, cityId);
		
		System.out.println("SQL: " + sql);
		ResultSet rs = stmt.executeQuery(sql);
		//while
		return result;
	}
	// 6번 문제 : 부서장 성으로 부서원 검색
	public static List<Emp> getDeptHeadFistName(String getFirstName) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		
		String sql = "select * from employees e join departments d on e.department_id = d.department_id where e.first_name = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, getFirstName);
		
		
		
		ResultSet rs = stmt.executeQuery();
		//while
		return result;
	}

	//7번 문제 : 나라이름으로 직원조회
	public static List<Emp> getEmpListByCountryName(String cityName) throws Exception {
		System.out.println("나라 이름 : ");
		Scanner scan = new Scanner(System.in);
		String countryName = scan.nextLine();
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		
		
		String sql = "select c.country_name, e.employee_id, e.last_name, e.phone_number, e.salary\r\n"
				+ "from employees e\r\n" + "	join departments d on e.department_id = d.department_id\r\n"
				+ "	join locations l on l.location_id = d.location_id\r\n"
				+ "	join countries c on c.country_id = l.country_id " + " where c.country_name = '" + cityName + "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, cityName);
		
		
		ResultSet rs = stmt.executeQuery(sql);
		//while

		return result;

	}


}