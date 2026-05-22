package Lab2.problem5;

public abstract class Animal {
	private String name;
	private int age;

	public Animal(String n, int a) {
		name = n;
		age = a;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public abstract String getSound();

	public String toString() {
		return name + "(age=" + age + ") says " + getSound();
	}
}
