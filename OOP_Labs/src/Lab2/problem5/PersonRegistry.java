package Lab2.problem5;

import java.util.ArrayList;

public class PersonRegistry {
	private ArrayList<Person> people = new ArrayList<>();

	public void addPerson(Person p) {
		people.add(p);
	}

	public void removePerson(Person p) {
		people.remove(p);
	}

	public ArrayList<Person> withPets() {
		ArrayList<Person> r = new ArrayList<>();
		for (Person p : people)
			if (p.hasPet())
				r.add(p);
		return r;
	}

	public ArrayList<Person> withoutPets() {
		ArrayList<Person> r = new ArrayList<>();
		for (Person p : people)
			if (!p.hasPet())
				r.add(p);
		return r;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("=== Registry ===\n");
		for (Person p : people)
			sb.append(p).append("\n");
		return sb.toString();
	}
}
