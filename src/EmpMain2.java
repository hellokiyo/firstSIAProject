

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmpMain2 {

	
	public static void main(String[] args) throws Exception {
		// 1.직원이름을 입력받아서 그 부서에 근무하는 직원들의 정보을 출력함
				System.out.print("직원이름 : (ex : steven King)");
				Scanner scan = new Scanner(System.in); 
				String input = scan.nextLine();

				String[] name = input.split(" ");

				String firstName = name[0];
				String lastName = name[1];

				List<Emp> empList = new ArrayList<Emp>();

				while (true) {
					EmpDAOP dao = new EmpDAOP();

					if (input.equals("0")) {
						break;
					} else {
				
						System.out.println("직원 이름으로 직원 정보를 출력합니다.");
						Emp emp = (Emp) EmpDAOP.getEmpByFirstNLastName(firstName, lastName);
						empList.add(emp);
						System.out.println(empList.getLast());
						// 재입력
						System.out.print("직원이름 : (ex : steven King)");
						input = scan.nextLine();
						if (input.length() == 0) {
							break;
						}

					}
				}
		

		// 2.입사년도를 전달받아서 그 부서의 부서원정보를 출력함
		while (true) {
			System.out.print("입사년도 입력 (예: 2017, 0 입력 시 종료): ");
			input = scan.nextLine();

			if (input.equals("0")) {
				break; // 종료 메시지 없이 그냥 종료
			}

			try {
				int year = Integer.parseInt(input);
				List<Emp> empListByYear = EmpDAOP.getEmpListByYear(year);

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
		
		// 3.부서번호를 전달받아서 그 부서의 부서원정보를 리턴함
		while (true) {
			System.out.print("부서번호 입력 (예: 90): ");
			input = scan.nextLine();

			if (input.equals("0")) {
				break; // 종료 메시지 없이 그냥 종료
			}

			try {
				int depId = Integer.parseInt(input);
				List<Emp> empListBydepId = EmpDAOP.getEmpListBydepId(depId);

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
		// 4.직무를 전달받아서 그 부서의 부서원정보를 리턴함
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
				List<Emp> empListByjobId = EmpDAOP.getEmpListByjobId(jobId.toUpperCase()); // 대문자로 맞춰줌

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
			
		}// 5.도시이름을 전달받아서 그 부서의 부서원정보를 리턴함
		while (true) {
			System.out.print("도시이름 입력 (예: Tokyo, 0 입력 시 종료): ");
			String cityId = scan.nextLine().trim();

			if (cityId.equals("0")) {
				break;
			}

			if (cityId.length() == 0) {
				System.out.println("도시이름을 입력해주세요.\n");
				continue;
			}

			try {
				List<Emp> empListBycityId = EmpDAOP.getEmpListBycityId(cityId.toUpperCase()); // 대문자로 맞춰줌

				if (empListBycityId.isEmpty()) {
					System.out.println("직무코드 '" + cityId + "'에 해당하는 직원이 없습니다.\n");
				} else {
					System.out.println("직무코드 '" + cityId + "'의 직원 목록:");
					for (Emp emp : empListBycityId) {
						System.out.println(emp);
					}
					System.out.println("총 " + empListBycityId.size() + "명의 직원이 검색되었습니다.\n");
				}
			} catch (Exception e) {
				System.out.println("오류 발생: " + e.getMessage());
			}
	
		//scan.close();
		}
		
	}
		
		
	}
		
	



		


