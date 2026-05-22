package lab3.problem4;

import java.util.*;

public class Problem4 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1 = new Employee("Alice", 50000, new Date(120, 0, 1), "INS001");
		Employee e2 = new Employee("Bob", 60000, new Date(119, 5, 15), "INS002");
		Employee e3 = new Employee("Charlie", 50000, new Date(121, 3, 10), "INS003");

		Manager m1 = new Manager("Diana", 80000, new Date(115, 0, 1), "INS004", 10000);
		m1.addEmployee(e1);
		m1.addEmployee(e2);

		Manager m2 = new Manager("Eve", 80000, new Date(116, 6, 1), "INS005", 15000);

		System.out.println(e1);
		System.out.println(m1);
		System.out.println("e1.compareTo(e2): " + e1.compareTo(e2));
		System.out.println("m1.compareTo(m2): " + m1.compareTo(m2));

		Employee[] arr = { e2, e1, e3 };
		Arrays.sort(arr, Employee.byName);
		System.out.println("By name: " + Arrays.toString(arr));
		Arrays.sort(arr, Employee.byHireDate);
		System.out.println("By hire: " + Arrays.toString(arr));

		Manager m1c = m1.clone();
		m1c.getTeam().get(0).setName("Modified");
		System.out.println("Original: " + m1.getTeam().get(0).getName());
		System.out.println("Clone: " + m1c.getTeam().get(0).getName());
	}
}
