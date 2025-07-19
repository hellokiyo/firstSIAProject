

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project.Emp;
import project.EmpDAO;

// 기능 클래스 (사용자에게 입력받고, 정보를 출력해주는 기능을 구현)
public class Function {

	static Scanner scan = new Scanner(System.in);

	// 1. 직원이름으로 직원정보 검색
	public void searchEmployeeByName() throws Exception {

		System.out.print("직원이름 (ex.steven King) : ");
		String input = scan.nextLine();

		String[] name = input.split(" ");
		String firstName = name[0];
		String lastName = name[1];
		List<Emp> empList = new ArrayList<Emp>();

		while (true) {
			EmpDAO dao = new EmpDAO();

			if (input.equals("0")) {
				break;
			} else {
				System.out.println("직원 이름으로 직원 정보를 출력합니다.");
				Emp emp = EmpDAO.getEmpByFirstNLastName(firstName, lastName);
				empList.add(emp);
				System.out.println(empList.getLast());
				System.out.print("직원이름 : (ex : steven King)");
				input = scan.nextLine();
				if (input.length() == 0) {
					break;
				}
			}	
		}
		
	}

	// 2. 입사년도를 전달받아서 그 부서의 부서원정보를 출력함
	public void searchEmployeeByHireYear() throws Exception {
		
		while (true) {
			System.out.print("입사년도 입력 (ex.2017): ");
			String input = scan.nextLine();

			if (input.equals("0")) {
				break;
			}

			try {
				int year = Integer.parseInt(input);
				List<Emp> empListByYear = EmpDAO.getEmpListByYear(year);

				if (empListByYear.isEmpty()) {
					System.out.println(year + "년에 입사한 직원이 없습니다.\n");
				} else {
					System.out.println(year + "년에 입사한 직원 목록:");
					for (Emp emp : empListByYear) {
						System.out.println(emp);
					}
					System.out.println("총 " + empListByYear.size() + "명의 직원이 검색되었습니다.\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("입사년도를 숫자로 정확히 입력하세요.\n");
			}
		}
		
	}

	// 3. 부서번호를 전달받아서 그 부서의 부서원정보를 리턴함
	public void searchEmployeeByDeptNo() throws Exception {
		
		while (true) {
			System.out.print("부서번호 입력 (ex.90) : ");
			String input = scan.nextLine();

			if (input.equals("0")) {
				break;
			}

			try {
				int depId = Integer.parseInt(input);
				List<Emp> empListBydepId = EmpDAO.getEmpListBydepId(depId);

				if (empListBydepId.isEmpty()) {
					System.out.println(depId + "부서번호의 직원이 없습니다.\n");
				} else {
					System.out.println("부서번호" + depId + "의 직원 목록:");
					for (Emp emp : empListBydepId) {
						System.out.println(emp);
					}
					System.out.println("총 " + empListBydepId.size() + "명의 직원이 검색되었습니다.\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("입사년도를 숫자로 정확히 입력하세요.\n");
			}
		}
		
	}

	// 4. 직무를 전달받아서 그 부서의 부서원정보를 리턴함
	public void searchEmployeeByJobId() {
		
		while (true) {
			System.out.print("직무코드 입력 (예: IT_PROG, 0 입력 시 종료): ");
			String jobId = scan.nextLine().trim();

			if (jobId.equals("0")) {
				break;
			}

			if (jobId.length() == 0) {
				System.out.println("직무코드를 입력해주세요.\n");
				continue;
			}

			try {
				List<Emp> empListByjobId = EmpDAO.getEmpListByjobId(jobId.toUpperCase()); // 대문자로 맞춰줌

				if (empListByjobId.isEmpty()) {
					System.out.println("직무코드 '" + jobId + "'에 해당하는 직원이 없습니다.\n");
				} else {
					System.out.println("직무코드 '" + jobId + "'의 직원 목록:");
					for (Emp emp : empListByjobId) {
						System.out.println(emp);
					}
					System.out.println("총 " + empListByjobId.size() + "명의 직원이 검색되었습니다.\n");
				}
			} catch (Exception e) {
				System.out.println("오류 발생: " + e.getMessage());
			}

		}
		
	}

	// 5. 도시이름을 전달받아서 그 부서의 부서원정보를 리턴함
	public void searchEmployeeByCity() {
		while (true) {
			System.out.print("도시이름 입력 (예: Tokyo, 0 입력 시 종료): ");
			String city = scan.nextLine().trim();

			if (city.equals("0")) {
				break;
			}

			if (city.length() == 0) {
				System.out.println("도시이름을 입력해주세요.\n");
				continue;
			}

			try {
				List<Emp> empListBycityName = EmpDAO.getEmpListBycityId(city.toUpperCase()); // 대문자로 맞춰줌

				if (empListBycityName.isEmpty()) {
					System.out.println("직무코드 '" + city + "'에 해당하는 직원이 없습니다.\n");
				} else {
					System.out.println("직무코드 '" + city + "'의 직원 목록:");
					for (Emp emp : empListBycityName) {
						System.out.println(emp);
					}
					System.out.println("총 " + empListBycityName.size() + "명의 직원이 검색되었습니다.\n");
				}
			} catch (Exception e) {
				System.out.println("오류 발생: " + e.getMessage());
			}
		}
	}

	// 6. 부서장 성으로 부서원 검색
	public void searchEmployeeByManagerLastName() throws Exception {
		
		System.out.printf("부서장의 성 입력 : ");
		String getFirstName = scan.nextLine();

		while (getFirstName != null && getFirstName.length() !=0) { // 입력받은 "getName값이 0이 아니다" 를 true값을 가진다면 계속 반복 // 키보드로 0을 입력했을경우 break;
			System.out.println("입력한 부서장 성 : " + getFirstName);
			List<Emp> empList = EmpDAO.getDeptHeadFistName(getFirstName); // db접속

			for (Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.println("부서장 성이 " + getFirstName + "인 부서에서 근무하는 직원 수 : " + "명");
			System.out.println("부서장 성 입력 : ");
			getFirstName = scan.nextLine();
		}
	}

	// 7. 나라이름으로 직원정보 검색
	public void searchEmployeeByCountry() throws Exception {
		
		System.out.print("나라이름 (종료는 엔터) : ");
		String country = scan.nextLine();

		while (country != null && country.length() != 0) {
			System.out.println("입력한 나라 이름 : " + country);
			List<Emp> empList = EmpDAO.getEmpListByCountryName(country);
			
			for (Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.println(country + "에서 근무하는 직원 수 : " + empList.size() + "명");
			System.out.print("cityName(종료하려면 엔터를 누르세요.) :");
			country = scan.nextLine();
		}
	}

}
