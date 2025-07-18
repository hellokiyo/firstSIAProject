import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
}
