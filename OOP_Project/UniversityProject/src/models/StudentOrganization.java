package models;

import java.io.Serializable;
import java.util.*;

public class StudentOrganization implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Student> members = new ArrayList<>();
    private Student head;

    public StudentOrganization(String name) {
        this.name = name;
    }

    public void addMember(Student s) {
        if (!members.contains(s)) members.add(s);
    }

    public void setHead(Student s) {
        if (!members.contains(s)) members.add(s);
        this.head = s;
    }

    public List<Student> getMembers() { return members; }
    public Student getHead() { return head; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Organization[" + name + ", members=" + members.size()
                + ", head=" + (head == null ? "?" : head.getName()) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentOrganization)) return false;
        return Objects.equals(name, ((StudentOrganization) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
