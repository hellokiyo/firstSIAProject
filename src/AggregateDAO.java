import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AggregateDAO {
	// 근속년수- 입사후 (몇년차) 이상인사람 
	static Properties props = new Properties();
	static FileReader fr;

	public static List<Aggregate> getAggregate() throws Exception {
		List<Aggregate> result = new ArrayList<Aggregate>();

		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt = conn.prepareStatement(props.getProperty("getAggregate"));
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Aggregate aggregate = new Aggregate();
			aggregate.tenure = rs.getInt("tenure");
			aggregate.count = rs.getInt("totalNumber");
			aggregate.avg = rs.getInt("avg");
			aggregate.max = rs.getInt("max");
			aggregate.min = rs.getInt("min");
			aggregate.sum = rs.getInt("sum");
			result.add(aggregate);
		}
		return result;
	}
	
	// 가장 많이 번 사원 10명
	public static List<Aggregate> getWhoIsBestSalary() throws Exception {
		List<Aggregate> result = new ArrayList<Aggregate>();

		fr = new FileReader("db-info.properties");
		props.load(fr);

		Connection conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("userName"), props.getProperty("password"));
		PreparedStatement stmt = conn.prepareStatement(props.getProperty("getWhoIsBestSalary"));
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Aggregate aggregate = new Aggregate();
			aggregate.fullName = rs.getString("fullName");
			aggregate.deptName = rs.getString("deptName");
			aggregate.tenure = rs.getInt("tenure");
			aggregate.salaryAnnual = rs.getInt("salaryAnnual");
			result.add(aggregate);
		}
		return result;


	}

}
