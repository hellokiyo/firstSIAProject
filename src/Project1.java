import java.util.List;
import java.util.Scanner;

// 나라이름으로 그 나라에 근무하는 직원을 조회할 수 있는가?
public class Project1 {
	public static void main(String[] args) throws Exception {
		
		System.out.print("나라이름 : ");
		
		// 나라이름 입력 받기
		Scanner scan = new Scanner(System.in);
		String countryName = scan.nextLine();
		
		// 직원정보 전달받아서 그 나라의 직원이름 리턴
		while(countryName != null && countryName.length() !=0 ) {
			System.out.println("입력한 나라 이름 : " + countryName);
			List<Emp> empList = EmpDAO.getEmpListByCountryName(countryName);
			System.out.printf("%1s\t %15s\t %13s\t %15s\t %10s\t \n", "country_name", "empolyee_id", "last_name", "phone_number", "salary");
			System.out.printf("%5s\t %15s\t %15s\t %20s\t %8s\t \n", emp.countryName, emp.id, emp.lastName, emp.phoneNumber, emp.salary);
			for (Emp emp : empList) {
			}
			System.out.println(countryName + "에서 근무하는 직원 수 : " + empList.size() + "명");
			System.out.print("cityName(종료하려면 엔터를 누르세요.) :");
			countryName = scan.nextLine();
		}
	}
}
