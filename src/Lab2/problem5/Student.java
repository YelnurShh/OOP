package Lab2.problem5;

public class Student extends Person {
	private String major;

	public Student(String n, int a, String m) {
		super(n, a);
		major = m;
	}

	public String getMajor() {
		return major;
	}

	public String getOccupation() {
		return "Student: " + major;
	}
}
