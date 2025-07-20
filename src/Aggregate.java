
public class Aggregate extends Emp {
	public int count;
	public int avg;
	public int max;
	public int min;
	public int sum;
	public int tenure;
	public String fullName;
	public String deptName;
	public int salary;
	public int salaryAnnual;
	
	@Override
	public String toString() {
		return String.format("%-6d %-10d %-10d %-10d %-10d %-8d", tenure, count, avg, max, min, sum);
	}

	public static void printCoulumnName() {
		System.out.printf("%-6s %-10s %-10s %-10s %-10s %-8s\n","연 차", "총 인원", "평균 급여", "최고 급여", "최소 급여", "총 급여");
	}
	
	public String toStringWhoIsBestSalary() {
	    return String.format("%-17s %-20s %-5d %,8d\n", fullName, deptName, tenure, salaryAnnual);
	}

	public static void printColumnName2() {
	    System.out.printf("%-17s %-18s %-2s %8s\n", "성 명", "부 서 명", "연 차", "연 봉");
	}






}