

import java.util.List;
import java.util.Scanner;

public class Project1 {
	public static void main(String[] args) throws Exception {
		
		Scanner scan1 = new Scanner(System.in);
		int selectNo = -1;
		
		while(selectNo != 0) {
			System.out.println("heemancompany 직원정보 조회 시스템");
			System.out.println("1. 직원 이름을 통한 직원정보 검색 기능");
			System.out.println("2. 입사년도 별 직원정보 검색 기능");
			System.out.println("3. 부서번호 별 직원정보 검색 기능");
			System.out.println("4. 직무 별 직원정보 검색 기능");
			System.out.println("5. 도시 별 직원정보 검색 기능");
			System.out.println("6. 부서장 성 별 부서원 검색 기능");
			System.out.println("7. 나라 별 근무하는 직원 검색 기능");

			System.out.println("종료를 원하면 '종료'라고 입력하세요.");
			System.out.print("번호 입ㄴ력 : ");

			System.out.println("8. 종료");
			System.out.print("번호 입력 : ");

			selectNo = scan1.nextInt();
			
			if(selectNo == 1) {
				
			} else if(selectNo == 2) {
				
			} else if(selectNo == 3) {
				
			} else if(selectNo == 4) {
				
			} else if(selectNo == 5) {
				
			} else if(selectNo == 6) {
				
			} else if(selectNo == 7) {
				EmpDAO.getEmpListByCountryName(null);
			} else if(selectNo == 8) {
				System.out.println("프로그램 종료합니다");
			} else {
				System.out.println("메뉴에 없는 기능입니다. 다시 선택하십시오.");
			}
			
		}
		
	}
}
