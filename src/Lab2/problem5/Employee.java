package Lab2.problem5;

public class Employee extends Person {
	private String role;

	public Employee(String n, int a, String r) {
		super(n, a);
		role = r;
	}

	public String getRole() {
		return role;
	}

	public String getOccupation() {
		return "Employee: " + role;
	}
}
