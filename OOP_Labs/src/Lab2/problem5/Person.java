package Lab2.problem5;

import java.util.Objects;

public abstract class Person {
	private String name;
	private int age;
	private Animal pet;

	public Person(String n, int a) {
		name = n;
		age = a;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Animal getPet() {
		return pet;
	}

	public void assignPet(Animal p) {
		pet = p;
	}

	public void removePet() {
		pet = null;
	}

	public boolean hasPet() {
		return pet != null;
	}

	public abstract String getOccupation();

	public void leavePetWith(Person other) {
		if (!hasPet()) {
			System.out.println(name + " has no pet to leave");
			return;
		}
		if (other instanceof PhDStudent && pet instanceof Dog) {
			System.out.println("Cannot leave dog with PhDStudent");
			return;
		}
		other.assignPet(pet);
		removePet();
	}

	public void retrievePetFrom(Person other) {
		if (!other.hasPet()) {
			System.out.println(other.getName() + " has no pet to return");
			return;
		}
		assignPet(other.getPet());
		other.removePet();
	}

	public String toString() {
		return name + "(age=" + age + ") [" + getOccupation() + "] pet=" + (hasPet() ? pet.getName() : "none");
	}

	public boolean equals(Object o) {
		if (!(o instanceof Person))
			return false;
		Person p = (Person) o;
		return age == p.age && Objects.equals(name, p.name);
	}

	public int hashCode() {
		return Objects.hash(name, age);
	}
}
