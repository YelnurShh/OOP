package Lab2.problem5;

public class PetTest {
	public static void main(String[] args) {
		Person john = new Employee("John", 30, "Engineer");
		Person alice = new PhDStudent("Alice", 26, "Comp. Science", "AI");
		Animal murka = new Cat("Murka", 5);
		Animal rex = new Dog("Rex", 3);

		john.assignPet(murka);

		PersonRegistry registry = new PersonRegistry();
		registry.addPerson(john);
		registry.addPerson(alice);

		System.out.println("Initial state:");
		System.out.println(registry);

		john.leavePetWith(alice);
		System.out.println("After John leaves Murka with Alice:");
		System.out.println(registry);

		john.retrievePetFrom(alice);
		System.out.println("After John retrieves Murka:");
		System.out.println(registry);

		System.out.println("Trying to leave dog with PhD student:");
		Person bob = new Employee("Bob", 35, "Manager");
		bob.assignPet(rex);
		bob.leavePetWith(alice);

		System.out.println("No pet case:");
		alice.leavePetWith(john);
	}
}
