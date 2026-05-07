package users;

import enums.Language;
import java.io.Serializable;

public abstract class Employee extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String employeeId;

	public Employee() {
	}

	public Employee(int id, String name, String email, String password, Language language, String employeeId) {
		super(id, name, email, password, language);
		this.employeeId = employeeId;
	}

	public void sendMessage(User to, String text) {
		System.out.println("[Employee] " + name + " -> " + to.getName() + ": " + text);
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Employee{id=" + id + ", name='" + name + "', employeeId='" + employeeId + "'}";
	}
}
