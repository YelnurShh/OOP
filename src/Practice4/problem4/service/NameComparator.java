package Practice4.problem4.service;

import pr4.interfaces.model.Student;
import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.getName().compareTo(b.getName());
    }
}
