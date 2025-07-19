

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
<<<<<<< HEAD
			System.out.println("종료를 원하면 '종료'라고 입력하세요.");
			System.out.print("번호 입ㄴ력 : ");
=======
			System.out.println("8. 종료");
			System.out.print("번호 입력 : ");
>>>>>>> 935d77d2cb427a48b0df3e3e136d994ca60d3817
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
		
		
		
		
		
		System.out.print("나라이름 : ");
		
		// 나라이름 입력 받기
		Scanner scan2 = new Scanner(System.in);
		String countryName = scan2.nextLine();
		
		// 직원정보 전달받아서 그 나라의 직원이름 리턴
		while(countryName != null && countryName.length() !=0 ) {
			System.out.println("입력한 나라 이름 : " + countryName);
			List<Emp> empList = EmpDAO.getEmpListByCountryName(countryName);
			System.out.printf("%1s\t %15s\t %13s\t %15s\t %10s\t \n", "country_name", "empolyee_id", "last_name", "phone_number", "salary");
			for (Emp emp : empList) {
<<<<<<< HEAD
=======

>>>>>>> c6436a77f6d6cbb49e03dcb598d0da0df7a8c42c

				System.out.printf("%5s\t %15s\t %15s\t %20s\t %8s\t \n", emp.countryName, emp.id, emp.lastName, emp.phone, emp.salary);


				System.out.printf("%5s\t %15s\t %15s\t %20s\t %8s\t \n", emp.countryName, emp.id, emp.lastName, emp.phone, emp.salary);
<<<<<<< HEAD
=======

>>>>>>> c6436a77f6d6cbb49e03dcb598d0da0df7a8c42c
			}
			System.out.println(countryName + "에서 근무하는 직원 수 : " + empList.size() + "명");
			System.out.print("cityName(종료하려면 엔터를 누르세요.) :");
			countryName = scan2.nextLine();
		}
	}
}
