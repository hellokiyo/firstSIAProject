import java.util.Scanner;// Scanner를 사용하기 위해 java.util 패키지에서 가져옴

public class Project1 {
	public static void main(String[] args) throws Exception {
		 // 사용자 입력을 받기 위한 Scanner 객체 생성 (System.in: 키보드 입력)
		Scanner scan1 = new Scanner(System.in);
		Function func = new Function(); // Function 클래스의 객체를 생성 (기능들을 실행하기 위함)
		Emp emp = new Emp();
		// 메뉴 선택 번호 초기화 (-1로 설정해 반복문 진입 유도)
		int selectNo = -1;
		// 사용자가 8번(종료)을 누르기 전까지 계속 반복
		while(selectNo != 8) {
			System.out.println("\n heemancompany 직원정보 조회 시스템");
			System.out.println("1. 직원 이름을 통한 직원정보 검색 기능");
			System.out.println("2. 입사년도 별 직원정보 검색 기능");
			System.out.println("3. 부서번호 별 직원정보 검색 기능");
			System.out.println("4. 직무 별 직원정보 검색 기능");
			System.out.println("5. 도시 별 직원정보 검색 기능");
			System.out.println("6. 부서장 성 별 부서원 검색 기능");
			System.out.println("7. 나라 별 근무하는 직원 검색 기능");
			System.out.println("8. 근속년수 직원검색 ");
			System.out.println("9. 연봉왕은 누구?");
			// 사용자에게 메뉴 번호 입력받음
			System.out.print("번호 입력 : ");
			// 숫자 입력 받음 (ex. 1, 2, 3 등)
			selectNo = scan1.nextInt();
			// 숫자 입력 후 줄바꿈(\n) 제거용 → 안 하면 다음 입력에 영향
			scan1.nextLine();
			 // 사용자가 입력한 번호에 따라 기능 실행
			switch (selectNo) {
			case 1:
				func.searchEmployeeByName();
				break;
			case 2:
				func.searchEmployeeByHireYear();
				break;
			case 3:
				func.searchEmployeeByDeptNo();
				break;
			case 4:
				func.searchEmployeeByJobId();
				break;
			case 5:
				func.searchEmployeeByCity();
				break;
			case 6:
				func.searchEmployeeByManagerLastName();
				break;
			case 7:
				func.searchEmployeeByCountry();
				break;
			case 8:
				func.upAggregate();
				break;
			case 9:
				func.searchByHighestSalary();
				break;
			case 10:
				System.out.println("프로그램을 종료합니다.");
			default: // 1~8이 아닌 숫자를 입력했을 때 안내문 출력
				System.out.println("메뉴에 없는 기능입니다. 다시 선택하십시오.");
			}			
		} scan1.close();// Scanner 닫기 (메모리 누수 방지)

		
	}
}

// swich (조건값) {case 값1: 실행문1; break; ... defalt: 기본 실행문;
