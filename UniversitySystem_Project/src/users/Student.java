package users;

import academic.Course;
import academic.Mark;
import enums.Language;
import organizations.StudentOrganization;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int MAX_CREDITS = 21;

	protected double gpa;
	protected int credits;
	protected int failCount;
	protected List<Course> courses;
	protected StudentOrganization organization;

	public Student() {
		this.courses = new ArrayList<>();
	}

	public Student(int id, String name, String email, String password, Language language) {
		super(id, name, email, password, language);
		this.courses = new ArrayList<>();
		this.gpa = 0.0;
		this.credits = 0;
		this.failCount = 0;
	}

	public void registerForCourse(Course course) {
		if (credits + course.getCredits() > MAX_CREDITS) {
			System.out.println("Cannot register: credit limit (21) exceeded.");
			return;
		}
		courses.add(course);
		credits += course.getCredits();
		System.out.println(name + " registered for: " + course.getName());
	}

	public List<Course> viewCourses() {
		return courses;
	}

	public List<Mark> viewMarks() {
		return new ArrayList<>();
	}

	public void viewTranscript() {
		System.out.println(name + "'s Transcript | GPA: " + gpa + " | Credits: " + credits);
	}

	public void getTranscript() {
		System.out.println("Generating transcript for " + name);
	}

	public void rateTeacher(Teacher teacher, int rating) {
		System.out.println(name + " rated " + teacher.getName() + ": " + rating + "/5");
	}

	public void joinOrganization(StudentOrganization organization) {
		this.organization = organization;
		organization.addMember(this);
		System.out.println(name + " joined organization: " + organization.getName());
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public StudentOrganization getOrganization() {
		return organization;
	}

	public void setOrganization(StudentOrganization organization) {
		this.organization = organization;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student))
			return false;
		Student that = (Student) o;
		return id == that.id && Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email);
	}

	@Override
	public String toString() {
		return "Student{id=" + id + ", name='" + name + "', gpa=" + gpa + ", credits=" + credits + "}";
	}
}
