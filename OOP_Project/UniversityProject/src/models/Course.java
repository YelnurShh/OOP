package models;

import enums.CourseType;
import java.io.Serializable;
import java.util.*;

public class Course implements Serializable, Comparable<Course> {
	private static final long serialVersionUID = 1L;

	private String courseId;
	private String name;
	private int credits;
	private CourseType type;
	private List<Teacher> teachers = new ArrayList<>();
	private List<Lesson> lessons = new ArrayList<>();
	private List<Student> students = new ArrayList<>();
	private String school;

	private Teacher lectureTeacher;
	private Teacher practiceTeacher;

	public Course(String courseId, String name, int credits, CourseType type, String school) {
		this.courseId = courseId;
		this.name = name;
		this.credits = credits;
		this.type = type;
		this.school = school;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getName() {
		return name;
	}

	public int getCredits() {
		return credits;
	}

	public CourseType getType() {
		return type;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getSchool() {
		return school;
	}

	public void setType(CourseType t) {
		this.type = t;
	}

	public void addTeacher(Teacher t) {
		if (!teachers.contains(t)) {
			teachers.add(t);
			if (!t.getCourses().contains(this))
				t.getCourses().add(this);
		}
	}

	public void addLesson(Lesson l) {
		lessons.add(l);
		if (l.getTeacher() != null)
			addTeacher(l.getTeacher());
	}

	public void addStudent(Student s) {
		if (!students.contains(s))
			students.add(s);
	}

	public void removeStudent(Student s) {
		students.remove(s);
	}

	public void setLectureTeacher(Teacher t) {
		this.lectureTeacher = t;
		addTeacher(t);
	}

	public void setPracticeTeacher(Teacher t) {
		this.practiceTeacher = t;
		addTeacher(t);
	}

	public Teacher getLectureTeacher() {
		return lectureTeacher;
	}

	public Teacher getPracticeTeacher() {
		return practiceTeacher;
	}

	@Override
	public int compareTo(Course o) {
		return courseId.compareTo(o.courseId);
	}

	@Override
	public String toString() {
		return courseId + " " + name + " [" + credits + "cr, " + type + ", " + school + "]"
				+ (lectureTeacher != null ? " Lec:" + lectureTeacher.getName() : "")
				+ (practiceTeacher != null ? " Prac:" + practiceTeacher.getName() : "");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Course))
			return false;
		return courseId.equals(((Course) o).courseId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId);
	}
}
