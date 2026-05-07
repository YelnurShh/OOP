package organizations;

import users.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentOrganization implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<Student> members;
	private Student head;

	public StudentOrganization() {
		this.members = new ArrayList<>();
	}

	public StudentOrganization(String name) {
		this.name = name;
		this.members = new ArrayList<>();
	}

	public void addMember(Student student) {
		if (!members.contains(student)) {
			members.add(student);
			System.out.println(student.getName() + " joined " + name);
		}
	}

	public void setHead(Student student) {
		if (!members.contains(student)) {
			members.add(student);
		}
		this.head = student;
		System.out.println(student.getName() + " is now head of " + name);
	}

	public List<Student> getMembers() {
		return members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getHead() {
		return head;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof StudentOrganization))
			return false;
		StudentOrganization that = (StudentOrganization) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "StudentOrganization{name='" + name + "', members=" + members.size() + ", head="
				+ (head != null ? head.getName() : "N/A") + "}";
	}
}
