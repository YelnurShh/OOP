package Practice4.problem4.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pr4.interfaces.model.Student;
import pr4.interfaces.services.NameComparator;

public class Main {

	public static void main(String[] args) {
		
		 List<Student> list = new ArrayList<>();
	        list.add(new Student("Zara", 3.2));
	        list.add(new Student("Aibek", 3.8));
	        list.add(new Student("Mira", 2.9));

	        Collections.sort(list);
	        System.out.println("By GPA: " + list);

	        Collections.sort(list, new NameComparator());
	        System.out.println("By name: " + list);

	}

}
