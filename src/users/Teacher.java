package users;

import academic.Course;
import academic.Mark;
import enums.Language;
import enums.TeacherPosition;
import enums.UrgencyLevel;
import interfaces.Researcher;
import research.ResearchPaper;
import research.ResearchProject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Teacher extends Employee implements Researcher, Serializable {

	private static final long serialVersionUID = 1L;

	private TeacherPosition position;
	private List<Course> courses;
	private List<ResearchPaper> papers;
	private List<ResearchProject> projects;

	public Teacher() {
		this.courses = new ArrayList<>();
		this.papers = new ArrayList<>();
		this.projects = new ArrayList<>();
	}

	public Teacher(int id, String name, String email, String password, Language language, String employeeId,
			TeacherPosition position) {
		super(id, name, email, password, language, employeeId);
		this.position = position;
		this.courses = new ArrayList<>();
		this.papers = new ArrayList<>();
		this.projects = new ArrayList<>();
	}

	public List<Course> viewCourses() {
		return courses;
	}

	public void manageCourse(Course course) {
		System.out.println(name + " is managing course: " + course.getName());
	}

	public void putMark(Student student, Mark mark) {
		System.out.println(name + " put mark for student: " + student.getName());
	}

	public List<Student> viewStudents() {
		return new ArrayList<>();
	}

	public void sendComplaint(Student student, UrgencyLevel level) {
		System.out.println("Complaint [" + level + "] by " + name + " about student: " + student.getName());
	}

	@Override
	public void publishPaper(ResearchPaper paper) {
		papers.add(paper);
		System.out.println(name + " published paper: " + paper.getTitle());
	}

	@Override
	public int calculateHIndex() {
		int h = 0;
		List<ResearchPaper> sorted = new ArrayList<>(papers);
		sorted.sort(ResearchPaper.BY_CITATIONS);
		for (int i = 0; i < sorted.size(); i++) {
			if (sorted.get(i).getCitations() >= i + 1) {
				h = i + 1;
			} else
				break;
		}
		return h;
	}

	@Override
	public void printPapers(Comparator<ResearchPaper> comparator) {
		List<ResearchPaper> sorted = new ArrayList<>(papers);
		sorted.sort(comparator);
		for (ResearchPaper p : sorted) {
			System.out.println(p);
		}
	}

	@Override
	public void joinResearchProject(ResearchProject project) {
		projects.add(project);
	}

	@Override
	public List<ResearchProject> getProjects() {
		return projects;
	}

	@Override
	public List<ResearchPaper> getPapers() {
		return papers;
	}

	public TeacherPosition getPosition() {
		return position;
	}

	public void setPosition(TeacherPosition position) {
		this.position = position;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Teacher{id=" + id + ", name='" + name + "', position=" + position + "}";
	}
}
