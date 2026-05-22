package models;

import enums.Language;
import enums.ManagerType;
import enums.UrgencyLevel;
import database.Database;
import java.util.*;

public class Manager extends Employee {
	private static final long serialVersionUID = 1L;

	private ManagerType type;
	private List<Request> complaints = new ArrayList<>();
	private List<Request> employeeRequests = new ArrayList<>();

	public Manager(int id, String name, String email, String pass, Language l, String empId, ManagerType type) {
		super(id, name, email, pass, l, empId);
		this.type = type;
	}

	public void assignCourse(Teacher t, Course c) {
		c.addTeacher(t);
		t.manageCourse(c);
		System.out.println("Manager " + name + " assigned " + c.getName() + " to " + t.getName());
	}

	public boolean approveRegistration(Student s, Course c) {
		if (s.getCourses().contains(c)) {
			System.out.println("Manager " + name + " approved registration of " + s.getName() + " for " + c.getName());
			return true;
		}
		return s.registerForCourse(c);
	}

	public void addCourseForRegistration(Course c, String major, int year) {
		Database.getInstance().addCourse(c);
		System.out.println("Manager " + name + " added " + c.getName() + " for " + major + " year " + year);
	}

	public void manageNews(News n) {
		Database.getInstance().addNews(n);
		if ("Research".equalsIgnoreCase(n.getTopic()))
			n.pin();
		System.out.println("Manager " + name + " published news: " + n.getTitle());
	}

	public String createStatisticalReport() {
		StringBuilder sb = new StringBuilder();
		sb.append("===== Statistical Report by ").append(name).append(" =====\n");
		Database db = Database.getInstance();
		int sCnt = 0, fCnt = 0;
		double gpaSum = 0;
		for (User u : db.getUsers()) {
			if (u instanceof Student) {
				Student st = (Student) u;
				sCnt++;
				gpaSum += st.getGpa();
				fCnt += st.getFailCount();
			}
		}
		sb.append("Students: ").append(sCnt).append("\n");
		sb.append("Avg GPA: ").append(sCnt == 0 ? "N/A" : String.format("%.2f", gpaSum / sCnt)).append("\n");
		sb.append("Total fails: ").append(fCnt).append("\n");
		sb.append("Total courses: ").append(db.getCourses().size()).append("\n");
		return sb.toString();
	}

	public List<Student> viewStudentsInfo() {
		List<Student> r = new ArrayList<>();
		for (User u : Database.getInstance().getUsers())
			if (u instanceof Student)
				r.add((Student) u);
		return r;
	}

	public List<Student> viewStudentsByGpa() {
		List<Student> r = viewStudentsInfo();
		r.sort((a, b) -> Double.compare(b.getGpa(), a.getGpa()));
		return r;
	}

	public List<Student> viewStudentsByName() {
		List<Student> r = viewStudentsInfo();
		Collections.sort(r);
		return r;
	}

	public List<Teacher> viewTeachersInfo() {
		List<Teacher> r = new ArrayList<>();
		for (User u : Database.getInstance().getUsers())
			if (u instanceof Teacher)
				r.add((Teacher) u);
		return r;
	}

	public List<Request> viewEmployeeRequests() {
		return employeeRequests;
	}

	public void receiveComplaint(Request r, UrgencyLevel level) {
		complaints.add(r);
	}

	public void receiveRequest(Request r) {
		employeeRequests.add(r);
	}

	public List<Request> getComplaints() {
		return complaints;
	}

	public ManagerType getManagerType() {
		return type;
	}

	@Override
	public String toString() {
		return "Manager " + name + " [" + type + "]";
	}
}
