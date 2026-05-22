package lab3.problem6;

import java.io.Serializable;

public class Pet implements Comparable<Pet>, Serializable, Feedable, Trainable {
	String name, type;
	int age;

	Pet(String n, String t, int a) {
		name = n;
		type = t;
		age = a;
	}

	public String toString() {
		return type + "{" + name + ", " + age + "}";
	}

	public int compareTo(Pet p) {
		return Integer.compare(age, p.age);
	}

	public void feed(String f) {
		System.out.println(name + " eats " + f);
	}

	public void train(String c) {
		System.out.println(name + " learns " + c);
	}
}
