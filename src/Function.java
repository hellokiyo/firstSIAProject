
// 필요한 유틸리티 클래스들을 가져옴
import java.util.List; // List 인터페이스 사용을 위해 import
import java.util.Scanner; // 사용자 입력을 받기 위한 Scanenr 클래스 import

// 기능 클래스 (사용자에게 입력받고, 정보를 출력해주는 기능을 구현) -> 결과 출력 역할
public class Function {
	// scanner은 사용자 키보드 입력을 읽기 위한 도구
	static Scanner scan = new Scanner(System.in);

	// =============================
	// 1번 기능: 이름으로 직원 검색
	// =============================
	public void searchEmployeeByName() throws Exception {
		while (true) { // 무한 반복문 시작 (직원을 계속 검색할 수 있음, 사용자가 "0"을 입력하면 종료
			System.out.print("\n직원이름 (ex. steven King, 종료는 0) : "); // 사용자에게 이름과 성을 입력받기 위한 안내 메세지 출력
			String input = scan.nextLine();// 키보드로 입력한 내용을 문자열로 받아서 input변수에 저장
			// 만약 사용자가 "0"을 입력하면, 반복문 종료(검색 종료)
			if (input.equals("0"))
				break;
			// 입력한 이름을 공백(" ") 기준으로 나눠서 name 배열에 저장
			// 예: "Steven King" → ["Steven", "King"]
			String[] name = input.split(" ");
			// Steven or steven king park을 입력했을 경우 경고메세지
			if (name.length != 2) {
				System.out.println("이름과 성을 공백으로 구분해서 입력하세요 (예: Steven King)");
				continue;// 경고 메시지 출력 후 다시 입력받기 위해 continue 사용
			} //// 아래 코드 건너뛰고 다시 반복문 처음으로 감
				// 배열에서 이름과 성을 꺼내어 각각 변수에 저장
			String firstName = name[0];
			String lastName = name[1];
			// try 여기 안의 코드는 정상적으로 동작하면 문제 없음 하지만 에러가 나면 바로 catch로 넘어감
			try { // DAO 클래스에서 이름과 성으로 직원 정보를 검색
					// 직원 검색
				Emp emp = EmpDAO.getEmpByFirstNLastName(firstName, lastName);

				// 검색 결과가 null이거나, employeeId가 0이라면 → 해당 직원이 없다는 뜻
				if (emp == null || emp.employeeId == 0) {
					System.out.println("직원 정보를 찾을 수 없습니다.");// 직원 없음 메시지 출력
				} else {
					Emp.printCoulumnFirstNLastName();
					// 직원이 존재하면 toString()으로 직원 정보 출력
					System.out.println(emp.toStringFirstNLastName());
				}

			} catch (Exception e) { // 예외(오류)가 발생했을 경우 메시지를 출력
									// 예: 데이터베이스 연결 오류, 쿼리 오류 등
				System.out.println("오류 발생 : " + e.getMessage());
			}
		}
	}

	// 2. 입사년도를 전달받아서 그 부서의 부서원정보를 출력함
	public void searchEmployeeByHireYear() throws Exception {
		// 반복문 시작 (사용자가 0을 입력하면 종료됨)
		while (true) {
			// 사용자에게 입사년도를 입력하라는 메시지를 출력
			System.out.print("\n입사년도 입력 (ex. 2015, 종료는 0) : ");
			String input = scan.nextLine();// 사용자 입력값을 문자열로 받음
			// 입력값이 "0"이면 반복문 종료 → 검색 종료
			if (input.equals("0"))
				break;

			try {
				// 입력값을 정수(int)로 변환 (예: "2015" → 2015)
				// 만약 숫자가 아니면 예외 발생 → catch로 이동
				int year = Integer.parseInt(input); // 여기서 선언하고 값 변환
				// 해당 년도에 입사한 직원 목록을 DAO에서 가져옴
				List<Emp> empListByYear = EmpDAO.getEmpListByYear(year);
				// 직원이 없을 경우 → 안내 메시지 출력
				if (empListByYear.isEmpty()) {
					System.out.println(year + "년에 입사한 직원이 없습니다.");
				} else {
					System.out.println(year + "년에 입사한 직원 목록:");// 직원이 있을 경우 → 안내 메시지 출력
					Emp.printCoulumnName();
					// 직원 목록을 하나씩 출력 (Emp 클래스의 toString() 사용)
					for (Emp emp : empListByYear) {
						System.out.println(emp);
					}
					// 직원 수 출력
					System.out.println("\n" + year + "년도에 입사한 직원 수 : " + empListByYear.size() + "명");
				}
				// 사용자가 숫자가 아닌 값을 입력했을 때 실행됨
				// 예: "abcd"나 "twenty" 입력 시
			} catch (NumberFormatException e) {
				System.out.println("오류 발생 (입력은 숫자만 가능합니다.): " + e.getMessage());
			}

			System.out.println("추가적인 정보");

		}
	}

	// 3. 부서번호를 전달받아서 그 부서의 부서원정보를 출력하는 기능
	public void searchEmployeeByDeptNo() throws Exception {
		// 반복문 시작 (사용자가 0을 입력하면 종료됨)
		while (true) {
			System.out.print("\n부서번호 입력 (ex. 90, 종료는 0) : ");
			String input = scan.nextLine();

			if (input.equals("0"))
				break;

			try {// 입력값을 정수(int)로 변환 (예: "90" → 90)
					// 만약 숫자가 아니면 예외 발생 → catch로 이동
				int depId = Integer.parseInt(input);
				// 해당 부서번호에 속한 직원 목록을 DAO에서 가져옴
				List<Emp> empListBydepId = EmpDAO.getEmpListBydepId(depId);
				// 결과가 비어 있다면 → 해당 부서에 직원이 없는 것
				if (empListBydepId.isEmpty()) {
					System.out.println(depId + "부서번호의 직원이 없습니다.");
				} else {
					// 직원이 있을 경우 목록 출력
					System.out.println("부서번호" + depId + "의 직원 목록");
					Emp.printCoulumnName();
					// 직원 하나씩 출력
					for (Emp emp : empListBydepId) {
						System.out.println(emp);
					}
					System.out.println("부서번호가 " + input + "인 부서에 근무하는 직원 수 " + empListBydepId.size() + "명");
				}
			} catch (NumberFormatException e) {// 사용자가 숫자가 아닌 값을 입력했을 경우 처리
												// 예: "abc"나 "!!" 같은 값
				System.out.println("오류 발생 : " + e.getMessage());
			}
		}

	}

	// 4. 직무를 전달받아서 그 부서의 부서원정보를 리턴함
	public void searchEmployeeByJobId() {

		while (true) {
			System.out.print("\n직무코드 입력 (ex. IT_PROG, 종료는 0) : ");
			// 사용자가 입력한 문자열을 받아 공백 제거 (앞뒤 공백)
			String jobId = scan.nextLine().trim();

			if (jobId.equals("0"))
				break;

			try { // DAO를 통해 입력한 직무코드에 해당하는 직원 목록을 조회
					// 입력한 코드가 소문자여도 전부 대문자로 변환해 검색되도록 함
				List<Emp> empListByjobId = EmpDAO.getEmpListByjobId(jobId.toUpperCase()); // 대문자로 맞춰줌
				// 결과가 비어 있다면 (직원이 없다면)
				if (empListByjobId.isEmpty()) {
					// 직원이 존재할 경우 → 목록 출력
					System.out.println("직무코드 '" + jobId + "'에 해당하는 직원이 없습니다.");
				} else {
					System.out.println("직무코드 '" + jobId + "'의 직원 목록");
					Emp.printCoulumnName();
					// 직원 리스트를 하나씩 출력 (toString() 활용)
					for (Emp emp : empListByjobId) {
						System.out.println(emp);
					}
					System.out.println("직무번호가 " + jobId + "인 직원 수 : " + empListByjobId.size() + "명");
				}
			} catch (Exception e) { // 예외가 발생하면 오류 메시지 출력 (예: DB 연결 문제 등)
				System.out.println("오류 발생: " + e.getMessage());
			}

		}

	}

	// 5. 도시이름을 전달받아서 그 부서의 부서원정보를 리턴함
	public void searchEmployeeByCity() {
		while (true) {
			System.out.print("\n도시이름 입력 (ex. roma, 종료는 0)): ");
			String city = scan.nextLine().trim();

			if (city.equals("0"))
				break;

			try {
				List<Emp> empListBycityName = EmpDAO.getEmpListBycityId(city.toUpperCase());

				if (empListBycityName.isEmpty()) {
					System.out.println("직무코드 '" + city + "'에 해당하는 직원이 없습니다.");
				} else {
					System.out.println("직무코드 '" + city + "'의 직원 목록");
					Emp.printCoulumnName();
					for (Emp emp : empListBycityName) {
						System.out.println(emp);
					}
					System.out.println("도시이름이 " + city + "인 도시에서 근무하는 직원 수 : " + empListBycityName.size() + "명");
				}
			} catch (Exception e) {
				System.out.println("오류 발생 : " + e.getMessage());
			}
		}
	}

	// 6. 부서장 성으로 부서원 검색
	public void searchEmployeeByManagerLastName() throws Exception {

		while (true) {

			System.out.printf("\n부서장의 성 입력 (ex. steven, 종료는 0) : ");
			String getFirstName = scan.nextLine();

			if (getFirstName.equals("0"))
				break;

			try {
				List<Emp> empList = EmpDAO.getDeptHeadFistName(getFirstName);
				Emp.printCoulumnName();
				for (Emp emp : empList) {
					System.out.println(emp);
				}
				System.out.println("부서장 성이 " + getFirstName + "인 부서에서 근무하는 직원 수 : " + empList.size() + "명");

			} catch (Exception e) {
				System.out.println("오류 발생: " + e.getMessage());

			}

		}

	}

	// 7. 나라이름으로 직원정보 검색
	public void searchEmployeeByCountry() throws Exception {

		while (true) {

			System.out.print("\n나라이름 (ex. canada, 종료는 0) : ");
			String country = scan.nextLine();

			if (country.equals("0"))
				break;

			try {
				List<Emp> empList = EmpDAO.getEmpListByCountryName(country);
				Emp.printCoulumnName();
				for (Emp emp : empList) {
					System.out.println(emp);
				}
				System.out.println(country + "에서 근무하는 직원 수 : " + empList.size() + "명");
			} catch (Exception e) {
				System.out.println("오류 발생 : " + e.getMessage());
			}
		}

	}

	// 8. 근속년수 직원검색
	public void upAggregate() throws Exception {
		// 해당 년도에 입사한 직원 목록을 DAO에서 가져옴
		List<Aggregate> aggregateTenur = AggregateDAO.getAggregate();
		System.out.println("직원 통계");// 통계 함
		Aggregate.printCoulumnName();
		// 직원 목록을 하나씩 출력 (Emp 클래스의 toString() 사용)
		for (Aggregate aggregate : aggregateTenur) {
			System.out.println(aggregate);
		}
		System.out.print("메뉴화면으로 돌아가려면 0 입력 : ");
		String input = scan.nextLine();
		if (input.equals("0"))
			return;
	}

	// 9. 연봉왕은 누구?
	public void searchByHighestSalary() throws Exception {
		
		List<Aggregate> aggregateSalary = AggregateDAO.getWhoIsBestSalary();
		System.out.println("돈 버는 속도는 각자 다르다.");
		Aggregate.printColumnName2();
		
		for (Aggregate aggregate : aggregateSalary) {
			System.out.println(aggregate.toStringWhoIsBestSalary());
		}
		System.out.println("메뉴화면으로 돌아가려면 0 입력 : ");
		String input = scan.nextLine();
		if (input.equals("0"))
			return;
	}

}
