// 필요한 라이브러리(기능 모음)를 불러옴
import java.io.FileReader;// 파일에서 텍스트(속성파일)를 읽어오는 클래스
import java.sql.Connection;// 데이터베이스와 연결하기 위한 객체
import java.sql.DriverManager;// 데이터베이스 연결을 위한 드라이버 클래스
import java.sql.PreparedStatement;// SQL문을 실행할 때 사용 (보안성 좋음)
import java.sql.ResultSet;// SQL 실행 결과를 받아오는 객체
import java.util.ArrayList;// 리스트(배열처럼 여러 개의 값을 담을 수 있음)
import java.util.List;// List 인터페이스 (ArrayList를 다룰 때 사용)
import java.util.Properties;// 속성 파일을 읽을 수 있는 객체 (설정 정보 담기)
//클래스 정의: EmpDAO는 데이터베이스와 관련된 작업을 담당하는 클래스
public class EmpDAO {
	// Properties 객체 생성: DB 접속 정보와 SQL문을 담을 공간
	static Properties props = new Properties();
	// FileReader: db-info.properties라는 파일을 읽기 위한 객체
	static FileReader fr;

	// [문제1] 직원의 이름(이름 + 성)으로 직원 정보를 가져오는 메서드 //Emp (직원 하나)
	public static Emp getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		Emp emp = new Emp();// Emp 객체 하나 생성: 여기에 결과를 담을 예정
		
		fr = new FileReader("db-info.properties");// db-info.properties 파일을 읽음 (DB 정보와 SQL문이 담겨 있음)
		props.load(fr);// 파일 내용을 Properties 객체에 로드 (키=값 형태로 저장)
		// 데이터베이스 연결: url, 사용자 이름, 비밀번호 사용 ..DB 접속 정보 읽어서 DB에 연결
		Connection conn = DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("userName"), props.getProperty("password"));
		// SQL문을 미리 준비: 이름과 성을 조건으로 한 SQL을 불러옴
		PreparedStatement stmt = conn.prepareStatement(props.getProperty("getEmpByFirstNLastName"));
		stmt.setString(1, firstName);// SQL문을 미리 준비: 이름과 성을 조건으로 한 SQL을 불러옴
		stmt.setString(2, lastName);// 두 번째 ?에 lastName
		ResultSet rs = stmt.executeQuery();// SQL문 실행, 결과를 rs(ResultSet)에 저장
		// 결과가 있을 동안 반복해서 읽기 (여기선 한 명만 조회된다고 가정)
		while (rs.next()) {// rs에서 컬럼 이름을 기준으로 값 꺼내서 emp에 저장 //while 돌면서 한 객체에 저장
			// ResultSet = rs에서 컬럼 값을 꺼내서emp 객체에 저장
			// 표 형태의 결과 테이블 = ResultSet 결과를 받음 하지만 표 형태라 그대로 사용할 수 없고,
			// 한 줄씩 꺼내서 re.next에 원하는 값을 하나씩 출력해야 함
			// 왜 꺼내야 해? 객체에 넣기 위해 / 우리가 프로그램에서 다루려면 Emp객체로 바꿔야 실제로 사용 가능
			// 말 그대로 표에서 값을 꺼내서(rs) -> 내 객체(Emp)에 복사하는 것
			// sql문 안에 자바 객체가 들어있는건 아니고 sql문은 그냥 데이터베이스 db에게 " 야 employee테이블에서 부서 번호가
			// 50인 직원들을 줘바!" 라고 하는 것 그러면 db가 찾은 결과를 표table형태로 보내줌
			// 자바는 그 표를 resultset이라는 구조를 받음 따라서 표를 자바 객체로 내가 직접 만드는 거임
			emp.employeeId = rs.getInt("employee_id");
			emp.email = rs.getString("email");
			emp.phoneNo = rs.getString("phone_number");
			emp.hireDate = rs.getString("hire_date");
			emp.jobId = rs.getString("job_id");
			emp.salary = rs.getInt("salary");
			emp.commission = rs.getDouble("commission_pct");
			emp.managerId = rs.getInt("manager_id");
			emp.departmentId = rs.getInt("department_id");
			 
		}
		
		// 직원 정보 담긴 emp 객체 반환
		
		return emp;
	}
 
	// [문제2] 입사 연도로 검색한 직원 목록을 가져오는 메서드 (여러 명이라 List로 반환) //List<Emp> (여러 명)
	public static List<Emp> getEmpListByYear(int year) throws Exception {
		List<Emp> result = new ArrayList<Emp>();// 결과를 저장할 리스트 생성 (Emp 객체 여러 개를 담음)

		fr = new FileReader("db-info.properties");// db-info.properties 파일 열기
		props.load(fr);// 파일 내용을 Properties 객체에 로드
		// DB 연결
		Connection conn = DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("userName"), props.getProperty("password"));
		// 입사연도 조건으로 SQL문 준비
		PreparedStatement stmt1 = conn.prepareStatement(props.getProperty("getEmpListByYear"));
		stmt1.setInt(1, year);// SQL문의 첫 번째 ? 자리에 year 값 채워넣기
		ResultSet rs = stmt1.executeQuery();// SQL 실행 결과를 rs에 저장
		// 결과가 여러 개일 수 있으므로 반복문으로 모든 직원 정보 읽기
		while (rs.next()) {
			Emp emp = new Emp();// 새 Emp 객체 생성해서 한 명 정보 저장 //while 돌면서 리스트에 계속 추가
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
			result.add(emp);// 리스트에 emp 객체 추가
		}
		
		return result;// 모든 직원 정보 담긴 리스트 반환
	}

	// 3번 문제 부서번호로 검색할 수 있는가?
	public static List<Emp> getEmpListBydepId(int depId) throws Exception {
		// 여러 명의 직원 정보를 담기 위한 리스트 생성
		List<Emp> result = new ArrayList<Emp>();
		// db-info.properties 파일을 열기 위한 객체 생성
		fr = new FileReader("db-info.properties");
		props.load(fr); // properties 객체에 파일 내용을 불러와서 저장 (url, sql문 등 읽기)
		//db연결: url, username, password를 이용해서 접속
		Connection conn = DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("userName"), props.getProperty("password"));
		// 부서번호로 검색하는 sql문을 준비 (getEmpListBtdepId 키에 해당하는 sql문 가져옴)
		PreparedStatement stmt = conn.prepareStatement(props.getProperty("getEmpListBydepId"));
		//sql문 안에 있는 ?에 실제 부서번호 값 넣기
		stmt.setInt(1, depId);
		//sql문 실행 후 결과를 rs에 저장
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) { //결과가 여러 줄일 수 있으니 while문으로 한줄씩 읽음
			Emp emp = new Emp(); // 한 명의 직원 정보를 담기 위한 Emp객체 생성
			// rs에서 각 열(column)의 값을 꺼내서 emp 객체에 저장
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
			result.add(emp); // 위에서 만든 emp객체를 리스트에 추가
		}
		return result; // 직원 목록을 모두 담은 리스트 반환
	}

	// 4번 문제 : 직무로 직원정보를 검색할 수 있는가?
	public static List<Emp> getEmpListByjobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>(); //여러 명의 직원 정보를 담을 리스트 생성
		// db-info.properties 파일을 읽기 위한 fr객체 생성
		fr = new FileReader("db-info.properties"); 
		props.load(fr); // properties 객체에 파일 내용 로드 (url, sql문 등)
		// db에 연결(url, username, password)
		Connection conn = DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("userName"), props.getProperty("password"));
		// 직무로 검색하는 sql문 준비 (getEmpListByjobId 키에 해당하는 쿼리)
		PreparedStatement stmt = conn.prepareStatement(props.getProperty("getEmpListByjobId"));
		stmt.setString(1, jobId); // sql문의 ? 자리에 실제 jobId넣기
		ResultSet rs = stmt.executeQuery(); // sql문 실행해서 결과를 rs에 저장
		while (rs.next()) { // 결과가 여러 명일 수 있으니 반복문으로 읽기
			Emp emp = new Emp(); // 직원 정보를 담을 Emp 객체 하나 생성
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
			result.add(emp); // 이 직원 정보를 리스트에 추가
		}
		return result; // 직무에 해당하는 직원들 리스트 반환

	}

	// 5번 문제 : 도시이름으로 직원정보를 검색할 수 있는가?
	public static List<Emp> getEmpListBycityId(String cityId) throws Exception {
		List<Emp> result = new ArrayList<Emp>(); // 여러명의 직원을 담을 리스트 생성
		// db-info.properties를 읽기 위한 fr객체 생성
		fr = new FileReader("db-info.properties"); 
		props.load(fr);// properties 객체에 파일 내용 로드 (sql, url등)
		// db에 연결 (url, username, password)
		Connection conn = DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("userName"), props.getProperty("password"));
		// 도시이름으로 검색하는 sql문 준비 (getEmpListBycityId 키에 해당하는 쿼리)
		PreparedStatement stmt = conn.prepareStatement(props.getProperty("getEmpListBycityId"));
		stmt.setString(1, cityId); // sql문의 ? 자리에 실제 cityId넣기
		ResultSet rs = stmt.executeQuery(); //sql문 실행해서 rs에 저장
		
		
		while (rs.next()) { // 결과가 여러명일 수 있으니 반복문으로 읽기
			Emp emp = new Emp(); // 직원 정보를 담을 Emp 객체 하나 생성
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
			result.add(emp);// 이 직원 정보를 리스트에 추가
		}
		return result; // 도시이름에 해당하는 직원들 리스트 반환
	}

	// 6번 문제 : 부서장 성으로 부서원 검색하는 메서드
	public static List<Emp> getDeptHeadFistName(String getFirstName) throws Exception {
		List<Emp> result = new ArrayList<Emp>(); // 결과를 저장할 리스트 생성(직원 여러 명 저장)

		fr = new FileReader("db-info.properties"); // db-info.properties파일을 열기 위한 객체 생성
		props.load(fr); // 파일 내용을 props에 불러오기(url, sql문 같은 설정 읽음)
		//데이터베이스db에 연결 (url, user, password 정보 이용)
		Connection conn = DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("userName"), props.getProperty("password"));
		// 부서장의 이름으로 부서원 검색하는 sql문 준비
		PreparedStatement stmt = conn.prepareStatement(props.getProperty("getDeptHeadFistName"));
		stmt.setString(1, getFirstName); //sql문에 있는 ?자리에 실제 부서장 이름 넣기
		ResultSet rs = stmt.executeQuery(); // sql실행하고 결과를 rs에 저장

		while (rs.next()) { // 결과가 여러 줄일 수 있으므로 한 줄씩 반복해서 읽음
			Emp emp = new Emp(); // 한 명의 직원 정보를 담기 위한 객체 생성
			// ResultSet에서 컬럼 값을 꺼내서 emp 객체에 저장
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
			result.add(emp); // 이 직원 정보를 리스트에 추가
		}
		return result; // 최종적으로 부서원 정보 목록 반환
	}

	// 7번 문제 : 특정 나라에 속한 직원들을 찾는 메서드
	public static List<Emp> getEmpListByCountryName(String cityName) throws Exception {
		List<Emp> result = new ArrayList<Emp>(); // 결과를 저장할 리스트 생성(직원 여러 명 저장)

		fr = new FileReader("db-info.properties");// db-info.properties 파일 열기 위한 객체 생성
		props.load(fr);// 설정 파일을 props에 불러오기 (sql, url문 등)
		// db에 연결(url, username, password)
		Connection conn = DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("userName"), props.getProperty("password"));
		//나라 이름으로 직원 정보 검색하는 sql문 불러오기
		PreparedStatement stmt = conn.prepareStatement(props.getProperty("getEmpListByCountryName"));
		stmt.setString(1, cityName); //sql문 ? 자리에 나라 이름 넣기
		ResultSet rs = stmt.executeQuery(); // sql 실행 결과를 rs에 저장

		while (rs.next()) { // 결과가 여러 줄일 수 있으므로 반복해서 한 명씩 읽기
			Emp emp = new Emp(); // 한 명의 직원 정보를 담을 객체 생성
			//rs에서 각 열 값을 꺼내서 emp에 저장
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
			result.add(emp); // 리스트에 emp객체 추가
		}

		return result; // 검색된 직원 목록 반환

	}

}