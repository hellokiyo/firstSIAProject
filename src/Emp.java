public class Emp {
	public int employeeId;
	public String firstName;
	public String lastName;
	public String email;
	public String phoneNo;
	public String hireDate;
	public String jobId;
	public int salary;
	public double commission;
	public int managerId;
	public int departmentId;

	@Override // 객체 정보를 보기 좋게 문자열로 만들어주는 메서드 (toString 오버라이딩)

	public String toString() {
		return String.format("%-4d %-10s %-15s %-12s %-15s %-12s %-10s %8d %10.2f", employeeId, firstName, lastName,
				email, phoneNo, hireDate.substring(0, 10), jobId, salary, commission);
	}

	public static void printCoulumnName() {
		System.out.printf("%-4s %-10s %-15s %-12s %-15s %-12s %-10s %8s %10s\n", "ID", "FirstName", "LastName", "Email",
				"Phone", "HireDate", "JobID", "Salary", "Commission");
	}

	public String toStringFirstNLastName() {
	    return String.format(
	        "%-4d %-10s %-15s %-12s %-10s %8d %10.2f %10d %10d",
	        employeeId, email, phoneNo,
	        hireDate.substring(0, 10), jobId, salary, commission, managerId, departmentId
	    );
	}

	public static void printCoulumnFirstNLastName() {
	    System.out.printf(
	        "%-4s %-10s %-15s %-12s %-10s %8s %10s %10s %10s\n",
	        "ID", "Email", "Phone", "HireDate",
	        "JobID", "Salary", "Commission", "ManagerID", "DeptID"
	    );
	}


}
