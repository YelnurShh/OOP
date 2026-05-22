package models;

import enums.Language;
import enums.TeacherPosition;
import enums.UrgencyLevel;
import interfaces.Researcher;
import java.util.*;

public class Teacher extends Employee implements Researcher {
	private static final long serialVersionUID = 1L;

	private TeacherPosition position;
	private List<Course> courses = new ArrayList<>();
	private List<ResearchPaper> papers = new ArrayList<>();
	private List<ResearchProject> projects = new ArrayList<>();
	private String school;

	public Teacher(int id, String name, String email, String pass, Language l, String empId, TeacherPosition position,
			String school) {
		super(id, name, email, pass, l, empId);
		this.position = position;
		this.school = school;
	}

	public List<Course> viewCourses() {
		return courses;
	}

	public void manageCourse(Course c) {
		if (!courses.contains(c))
			courses.add(c);
		if (!c.getTeachers().contains(this))
			c.getTeachers().add(this);
		System.out.println(name + " is managing " + c.getName());
	}

	public void putMark(Student s, Course c, Mark m) {
		if (!s.getCourses().contains(c)) {
			System.out.println("Student is not registered for this course.");
			return;
		}
		s.receiveMark(c, m);
		System.out.println(name + " put marks for " + s.getName() + " in " + c.getName() + ": " + m);
	}

	public List<Student> viewStudents(Course c) {
		return c.getStudents();
	}

	public void sendComplaint(Manager dean, Student s, UrgencyLevel level, String reason) {
		Request r = new Request("Complaint about " + s.getName() + " (" + level + "): " + reason, this);
		dean.receiveComplaint(r, level);
		System.out
				.println("[COMPLAINT-" + level + "] " + name + " -> dean " + dean.getName() + " about " + s.getName());
	}

	public TeacherPosition getPosition() {
		return position;
	}

	public void setPosition(TeacherPosition p) {
		this.position = p;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public String getSchool() {
		return school;
	}

	public boolean isAlwaysResearcher() {
		return position == TeacherPosition.PROFESSOR;
	}

	@Override
	public List<ResearchPaper> getPapers() {
		return papers;
	}

	@Override
	public List<ResearchProject> getProjects() {
		return projects;
	}

	@Override
	public String getResearcherName() {
		return name;
	}

	@Override
	public String toString() {
		return "Teacher " + name + " [" + position + ", " + school + "]";
	}
}
