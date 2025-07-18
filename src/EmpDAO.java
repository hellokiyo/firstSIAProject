import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
			emp.email = rs.getString("email");
			emp.id = rs.getInt("employee_id");
			emp.phone = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;
	}

public static List<Emp> getEmpListByCountryName(String cityName) throws Exception {
	
	// 나라 이름으로 그 나라에 근무하는 직원을 조회할 수 있는가
	List<Emp> result = new ArrayList<Emp>();
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr","root","rootroot");
	Statement stmt = conn.createStatement();
	String sql = "select c.country_name, e.employee_id, e.last_name, e.phone_number, e.salary\r\n"
					+ "from employees e\r\n"
					+ "	join departments d on e.department_id = d.department_id\r\n"
					+ "	join locations l on l.location_id = d.location_id\r\n"
					+ "	join countries c on c.country_id = l.country_id " 
					+ " where c.country_name = '" + cityName + "'";
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()) {
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


}
