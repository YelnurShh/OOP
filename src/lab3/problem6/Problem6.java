package lab3.problem6;

import java.util.Arrays;

public class Problem6 {
	public static void main(String[] args) {
		Pet p1 = new Pet("Rex", "Dog", 3);
		Pet p2 = new Pet("Mimi", "Cat", 1);
		Pet p3 = new Pet("Buddy", "Dog", 5);

		p1.feed("bone");
		p1.train("sit");

		Pet[] pets = { p1, p2, p3 };
		Arrays.sort(pets);
		System.out.println("Pets by age: " + Arrays.toString(pets));

		PersonV2 h1 = new PersonV2("John", 25, p1);
		PersonV2 h2 = new PersonV2("Jane", 22);
		h1.feed("pizza");
		System.out.println(h1);

		PersonV2[] people = { h1, h2 };
		Arrays.sort(people);
		System.out.println("People by age: " + Arrays.toString(people));
	}
}
