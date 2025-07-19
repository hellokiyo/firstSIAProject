import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBSettings {
	private void settings() throws Exception {
			List<Emp> result = new ArrayList<Emp>();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
			
			
			PreparedStatement stmt = null;
			
			
			stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			
			
			
			
			
			
			Emp emp = new Emp();
			
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
		

	}
}
