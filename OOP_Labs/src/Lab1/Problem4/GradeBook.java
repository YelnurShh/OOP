package Lab1.Problem4;

import java.util.ArrayList;
import Practice2.Student;

public class GradeBook {

	private Course course;
	private ArrayList<Student> students;

	public GradeBook(Course course) {
		this.course = course;
		this.students = new ArrayList<>();
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public void displayMessage() {
		System.out.println("Welcome to the grade book for " + course.getCode() + " " + course.getName() + "!");
	}

	public double determineClassAverage() {
		if (students.isEmpty())
			return 0;

		double sum = 0;
		for (Student s : students) {
			sum += s.getGrade();
		}
		return sum / students.size();
	}

	public Student getBestStudent() {
		if (students.isEmpty())
			return null;

		Student best = students.get(0);
		for (Student s : students) {
			if (s.getGrade() > best.getGrade()) {
				best = s;
			}
		}
		return best;
	}

	public Student getWorstStudent() {
		if (students.isEmpty())
			return null;

		Student worst = students.get(0);
		for (Student s : students) {
			if (s.getGrade() < worst.getGrade()) {
				worst = s;
			}
		}
		return worst;
	}

	public void outputBarChart() {

		int[] frequency = new int[11];

		for (Student s : students) {
			int grade = (int) s.getGrade();

			if (grade == 100)
				frequency[10]++;
			else
				frequency[grade / 10]++;
		}

		System.out.println("\nGrades distribution:");

		for (int i = 0; i < frequency.length; i++) {

			if (i == 10)
				System.out.print("100:    ");
			else
				System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);

			for (int j = 0; j < frequency[i]; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

	public void displayGradeReport() {

		double avg = determineClassAverage();
		Student best = getBestStudent();
		Student worst = getWorstStudent();

		System.out.printf("\nClass average is ", avg);

		if (worst != null) {
			System.out.println(
					"Lowest grade is " + worst.getGrade() + " (" + worst.getName() + ", id: " + worst.getId() + ").");
		}

		if (best != null) {
			System.out.println(
					"Highest grade is " + best.getGrade() + " (" + best.getName() + ", id: " + best.getId() + ")");
		}

		System.out.println();

		outputBarChart();
	}
}