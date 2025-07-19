import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Aggregate {
	static Properties props = new Properties();
	static FileReader fr;
	
	public static List<Emp> getYearsOfService(int year) throws Exception {
		List<Emp> result = new ArrayList<Emp>();

		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("driverClassName"),
				props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt1 = conn.prepareStatement("getYearsofservice");
		stmt1.setInt(1, year);
		ResultSet rs = stmt1.executeQuery();

		while (rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.firstName = rs.getString("first_name");
			emp.lastName = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phoneNo = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getDouble("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
			result.add(emp);
		}

		
		return result;

	}
	
}
