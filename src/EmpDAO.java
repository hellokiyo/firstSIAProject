import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmpDAO {
	// 1번 문제 : 직원 이름으로 직원정보를검색할 수 있는가?
	static Emp emp = new Emp();
	static Properties props = new Properties();
	static FileReader fr;

	public static Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {

		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("driverClassName"),
				props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt = conn.prepareStatement(props.getProperty("getEmpByFirstNLastName"));
		ResultSet rs = stmt.executeQuery();

		stmt.setString(1, firstName);
		stmt.setString(2, lastName);

		while (rs.next()) {
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNo = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getInt("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
		}
		return emp;
	}

//리턴값 리스트 
	// 2번 문제 : 입사년도로 검색할 수 있는가?
	public static List<Emp> getEmpListByYear(int year) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		
		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("driverClassName"),
				props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt = conn.prepareStatement("getEmpListByYear");
		stmt.setInt(1, year);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNo = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getInt("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
			result.add(emp);
		}
		return result;
	}

	// 3번 문제 부서번호로 검색할 수 있는가?
	public static List<Emp> getEmpListBydepId(int depId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		
		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("driverClassName"),
				props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt = conn.prepareStatement("getEmpListBydepId");
		stmt.setInt(1, depId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNo = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getInt("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
			result.add(emp);
		}
		return result;
	}

	// 4번 문제 : 직무로 검색가능한가?
	public static List<Emp> getEmpListByjobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		
		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("driverClassName"),
				props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt = conn.prepareStatement("getEmpListByjobId");
		stmt.setString(1, jobId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNo = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getInt("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
			result.add(emp);
		}
		return result;

	}

	// 5번 문제 : 도시이름으로 직원정보 검색
	public static List<Emp> getEmpListBycityId(String cityId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		
		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("driverClassName"),
				props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt = conn.prepareStatement("getEmpListBycityId");
		stmt.setString(1, cityId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNo = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getInt("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
			result.add(emp);
		}
		return result;
	}

	// 6번 문제 : 부서장 성으로 부서원 검색
	public static List<Emp> getDeptHeadFistName(String getFirstName) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		
		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("driverClassName"),
				props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt = conn.prepareStatement("getDeptHeadFistName");
		stmt.setString(1, getFirstName);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNo = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getInt("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
			result.add(emp);
		}
		return result;
	}

	// 7번 문제 : 나라이름으로 직원조회
	public static List<Emp> getEmpListByCountryName(String cityName) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		
		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("driverClassName"),
				props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt = conn.prepareStatement("getEmpListByCountryName");
		stmt.setString(1, cityName);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNo = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getInt("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
			result.add(emp);
		}

		return result;

	}

}