package lab3.problem6;

import lab3.problem4.Person;
import java.io.Serializable;

public class PersonV2 extends Person implements Comparable<PersonV2>, Serializable, Feedable {
	int age;
	Pet pet;

	PersonV2(String n, int a) {
		super(n);
		age = a;
	}

	PersonV2(String n, int a, Pet p) {
		super(n);
		age = a;
		pet = p;
	}

	public int compareTo(PersonV2 p) {
		return Integer.compare(age, p.age);
	}

	public void feed(String f) {
		System.out.println(name + " eats " + f);
	}

	public String toString() {
		return "PersonV2{" + name + ", " + age + (pet != null ? ", pet=" + pet.name : "") + "}";
	}
}
