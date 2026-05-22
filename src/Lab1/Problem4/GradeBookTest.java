package Lab1.Problem4;

import java.util.Scanner;
import Practice2.Student;

public class GradeBookTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Course course = new Course("CS101", "Object-Oriented Programming", 5);
		GradeBook gradebook = new GradeBook(course);
		gradebook.displayMessage();

		System.out.print("How many students? ");
		int n = scanner.nextInt();

		System.out.println("Please, input grades for students:");

		for (int i = 0; i < n; i++) {

			System.out.println("\nStudent " + (i + 1));

			scanner.nextLine();

			System.out.print("Name: ");
			String name = scanner.nextLine();

			System.out.print("ID: ");
			int id = scanner.nextInt();

			System.out.print("Grade: ");
			double grade = scanner.nextDouble();

			Student s = new Student(name, id, grade);
			gradebook.addStudent(s);
		}

		System.out.println();
		gradebook.displayGradeReport();
	}
}