package lab3.problem4;

public class Person {
	protected String name;

	Person() {
		this.name = "Unknown";
	}

	protected Person(String n) {
		this.name = n;
	}

	String getName() {
		return name;
	}

	void setName(String n) {
		this.name = n;
	}

	public String toString() {
		return "Person{" + name + "}";
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Person))
			return false;
		return name.equals(((Person) o).name);
	}
}
