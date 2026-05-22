package models;

import enums.Language;

public abstract class Employee extends User {
	private static final long serialVersionUID = 1L;

	protected String empId;
	protected double salary;

	public Employee(int id, String name, String email, String pass, Language l, String empId) {
		super(id, name, email, pass, l);
		this.empId = empId;
	}

	public String getEmpId() {
		return empId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double s) {
		this.salary = s;
	}

	@Override
	public String toString() {
		return super.toString() + " [empId=" + empId + "]";
	}
}
