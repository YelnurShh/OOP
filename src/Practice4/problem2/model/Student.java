package Practice4.problem2.model;

public class Student extends Person implements CanHavePizza, CanHaveRetake, Movable, Comparable<Student> {
	private double gpa;

	public Student(String n, double g) {
		super(n);
		this.gpa = g;
	}

	public double getGpa() {
		return gpa;
	}

	@Override
	public void eatPizza() {
		System.out.println("eatPizza");
	}

	@Override
	public void retakeExam() {
		System.out.println("retakeExam");
	}

	@Override
	public void dance() {
		System.out.println("dance");
	}

	@Override
	public void move() {
		System.out.println("move");
	}

	@Override
	public int compareTo(Student o) {
		return Double.compare(this.gpa, o.gpa);
	}

	@Override
	public String toString() {
		return getName() + " (" + gpa + ")";
	}
}
