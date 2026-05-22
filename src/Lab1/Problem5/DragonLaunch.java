package Lab1.Problem5;

import java.util.Vector;

public class DragonLaunch {
	private Vector<Person> victims = new Vector<>();

	public void kidnap(Person p) {
		victims.add(p);
	}

	public boolean willDragonEatOrNot() {
		int boysToMatch = 0;

		for (Person p : victims) {
			if (p.getGender() == Gender.BOY) {
				boysToMatch++;
			} else {
				if (boysToMatch > 0) {
					boysToMatch--;
				} else {
					return true;
				}
			}
		}

		return boysToMatch > 0;
	}

	public static void main(String[] args) {
		DragonLaunch dl = new DragonLaunch();

		dl.kidnap(new Person(Gender.BOY));
		dl.kidnap(new Person(Gender.BOY));
		dl.kidnap(new Person(Gender.GIRL));
		dl.kidnap(new Person(Gender.GIRL));

		System.out.println("Victims: " + dl.victims);
		System.out.println("Will eat: " + dl.willDragonEatOrNot());
	}
}