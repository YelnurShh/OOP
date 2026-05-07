package academic;

import enums.CourseType;
import users.Teacher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	private String courseId;
	private String name;
	private int credits;
	private CourseType courseType;
	private List<Teacher> teachers;
	private List<Lesson> lessons;

	public Course() {
		this.teachers = new ArrayList<>();
		this.lessons = new ArrayList<>();
	}

	public Course(String courseId, String name, int credits, CourseType courseType) {
		this.courseId = courseId;
		this.name = name;
		this.credits = credits;
		this.courseType = courseType;
		this.teachers = new ArrayList<>();
		this.lessons = new ArrayList<>();
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public void addLesson(Lesson lesson) {
		lessons.add(lesson);
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Course))
			return false;
		Course that = (Course) o;
		return Objects.equals(courseId, that.courseId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId);
	}

	@Override
	public String toString() {
		return "Course{id='" + courseId + "', name='" + name + "', credits=" + credits + ", type=" + courseType + "}";
	}
}
