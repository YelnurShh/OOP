package lab3.problem4;

import java.util.Comparator;
import java.util.Date;

public class Employee extends Person implements Comparable<Employee>, Cloneable {
	double salary;
	Date hireDate;
	String insNum;

	Employee() {
		super();
		salary = 0;
		hireDate = new Date();
		insNum = "";
	}

	public Employee(String n, double s, Date h, String i) {
		super(n);
		salary = s;
		hireDate = h;
		insNum = i;
	}

	double getSalary() {
		return salary;
	}

	void setSalary(double s) {
		salary = s;
	}

	Date getHireDate() {
		return hireDate;
	}

	void setHireDate(Date h) {
		hireDate = h;
	}

	String getInsNum() {
		return insNum;
	}

	void setInsNum(String i) {
		insNum = i;
	}

	public String toString() {
		return "Employee{" + name + ", sal=" + salary + "}";
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Employee))
			return false;
		Employee e = (Employee) o;
		return name.equals(e.name) && salary == e.salary && insNum.equals(e.insNum);
	}

	public int compareTo(Employee e) {
		return Double.compare(salary, e.salary);
	}

	public Employee clone() throws CloneNotSupportedException {
		Employee c = (Employee) super.clone();
		c.hireDate = (Date) hireDate.clone();
		return c;
	}

	public static Comparator<Employee> byName = (a, b) -> a.name.compareTo(b.name);
	public static Comparator<Employee> byHireDate = (a, b) -> a.hireDate.compareTo(b.hireDate);
}
