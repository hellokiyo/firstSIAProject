import java.util.List;
import java.util.Scanner;

public class JDBCProject1 {

	public static void main(String[] args) throws Exception {
		System.out.println("부서장의 성을 입력해주세요 : (종료 : 그만)");
		Scanner scan = new Scanner(System.in);
		
		String getFirstName	=scan.nextLine();
		
		while(getFirstName != " ") { //입력받은 "getName값이 0이 아니다" 를 true값을 가진다면 계속 반복 // 키보드로 0을 입력했을경우 break;
						
			List<Emp> empList = EmpDAO.getDeptHeadFistName(getFirstName); //db접속
			
			for(Emp emp : empList) {
				System.out.println(emp);
			}
			System.out.println("부서장 성을 입력해주세요 : (종료 : 그만)");
			getFirstName =scan.nextLine();
		}
	}
	
	
	
}
