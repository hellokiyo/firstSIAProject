import java.util.Scanner;

public class Project1 {
	public static void main(String[] args) throws Exception {
		
		Scanner scan1 = new Scanner(System.in);
		int selectNo = -1;
		Function func = new Function();
		
		while(selectNo != 8) {
			System.out.println("heemancompany 직원정보 조회 시스템");
			System.out.println("1. 직원 이름을 통한 직원정보 검색 기능");
			System.out.println("2. 입사년도 별 직원정보 검색 기능");
			System.out.println("3. 부서번호 별 직원정보 검색 기능");
			System.out.println("4. 직무 별 직원정보 검색 기능");
			System.out.println("5. 도시 별 직원정보 검색 기능");
			System.out.println("6. 부서장 성 별 부서원 검색 기능");
			System.out.println("7. 나라 별 근무하는 직원 검색 기능");
			System.out.println("종료를 원하면 '종료'라고 입력하세요.");
			System.out.print("번호 입력 : ");

			System.out.println("8. 종료");
			System.out.print("번호 입력 : ");

			selectNo = scan1.nextInt();
			scan1.nextLine();
			switch (selectNo) {
			case 1:
				System.out.println("1번실행");
				func.searchEmployeeByName();
			case 2:
				func.searchEmployeeByHireYear();
			case 3:
				func.searchEmployeeByDeptNo();
			case 4:
				func.searchEmployeeByJobId();
			case 5:
				func.searchEmployeeByCity();
			case 6:
				func.searchEmployeeByManagerLastName();
			case 7:
				func.searchEmployeeByCountry();
			case 0:
				System.out.println("프로그램 종료합니다");
				break;
			default:
				System.out.println("메뉴에 없는 기능입니다. 다시 선택하십시오.");
			}			
		} scan1.close();

		
	}
}
