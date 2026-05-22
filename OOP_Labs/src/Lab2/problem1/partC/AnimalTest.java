package Lab2.problem1.partC;

import java.util.HashSet;

public class AnimalTest {
	public static void main(String[] args) {
		HashSet<Animal> set = new HashSet<>();

		Pet p1 = new Pet("Buddy", "Dog", "John");
		Pet p2 = new Pet("Buddy", "Dog", "John");
		Pet p3 = new Pet("Mimi", "Cat", "Alice");

		set.add(p1);
		set.add(p2);
		set.add(p3);

		System.out.println("Set size (should be 2): " + set.size());
		for (Animal a : set) {
			System.out.println(a);
		}
	}
}
