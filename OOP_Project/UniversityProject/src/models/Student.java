package models;

import enums.CourseType;
import enums.Language;
import java.util.*;

public class Student extends User {
	private static final long serialVersionUID = 1L;

	public static final int MAX_CREDITS = 21;
	public static final int MAX_FAILS = 3;

	protected double gpa;
	protected int credits;
	protected int failCount;
	protected String major;
	protected String school;
	protected int year;
	protected List<Course> courses = new ArrayList<>();

	protected Map<Course, Mark> marks = new LinkedHashMap<>();

	protected StudentOrganization organization;

	protected Map<Teacher, Integer> ratings = new HashMap<>();

	public Student(int id, String name, String email, String pass, Language l, String major, String school, int year) {
		super(id, name, email, pass, l);
		this.major = major;
		this.school = school;
		this.year = year;
	}

	public boolean registerForCourse(Course c) {
		if (failCount >= MAX_FAILS) {
			System.out.println("ERROR: " + name + " has failed " + failCount + " times, cannot register.");
			return false;
		}
		if (credits + c.getCredits() > MAX_CREDITS) {
			System.out.println("ERROR: " + name + " cannot register for " + c.getName() + " - credit limit ("
					+ MAX_CREDITS + ") exceeded.");
			return false;
		}
		if (c.getType() == CourseType.MAJOR && !canTakeAsMajor(c)) {
			System.out.println("ERROR: " + c.getName() + " is not in " + name + "'s major.");
			return false;
		}
		courses.add(c);
		c.addStudent(this);
		credits += c.getCredits();
		marks.put(c, new Mark());
		System.out.println("OK: " + name + " registered for " + c.getName());
		return true;
	}

	protected boolean canTakeAsMajor(Course c) {
		if ("SITE".equalsIgnoreCase(school) && "Oil and Gas".equalsIgnoreCase(c.getSchool())) {
			return false;
		}
		return c.getSchool().equalsIgnoreCase(school) || c.getType() != CourseType.MAJOR;
	}

	public List<Course> viewCourses() {
		return courses;
	}

	public Map<Course, Mark> viewMarks() {
		return marks;
	}

	public Transcript viewTranscript() {
		return getTranscript();
	}

	public Transcript getTranscript() {
		Transcript t = new Transcript(this);
		for (Map.Entry<Course, Mark> e : marks.entrySet())
			t.put(e.getKey(), e.getValue());
		return t;
	}

	public void rateTeacher(Teacher t, int rating) {
		if (rating < 1 || rating > 5) {
			System.out.println("Rating must be 1-5");
			return;
		}
		ratings.put(t, rating);
		System.out.println(name + " rated " + t.getName() + " with " + rating);
	}

	public void joinOrganization(StudentOrganization o) {
		this.organization = o;
		o.addMember(this);
	}

	public void receiveMark(Course c, Mark m) {
		marks.put(c, m);
		if (m.isFailed())
			failCount++;
		recalculateGpa();
	}

	private void recalculateGpa() {
		this.gpa = getTranscript().computeGpa();
	}

	public double getGpa() {
		return gpa;
	}

	public int getCredits() {
		return credits;
	}

	public int getFailCount() {
		return failCount;
	}

	public String getMajor() {
		return major;
	}

	public String getSchool() {
		return school;
	}

	public int getYear() {
		return year;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public Map<Course, Mark> getMarks() {
		return marks;
	}

	public StudentOrganization getOrganization() {
		return organization;
	}

	public Map<Teacher, Integer> getRatings() {
		return ratings;
	}

	public void setOrganization(StudentOrganization o) {
		this.organization = o;
	}

	@Override
	public int compareTo(User o) {
		if (o instanceof Student) {
			return this.name.compareToIgnoreCase(((Student) o).name);
		}
		return this.name.compareToIgnoreCase(o.getName());
	}

	@Override
	public String toString() {
		return "Student " + name + " [" + major + ", year " + year + ", GPA=" + String.format("%.2f", gpa) + "]";
	}
}
