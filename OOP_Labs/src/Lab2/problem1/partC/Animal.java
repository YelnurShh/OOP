package Lab2.problem1.partC;

import java.util.Objects;

public class Animal {
	private String name;
	private String type;

	public Animal(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Animal))
			return false;
		Animal a = (Animal) o;
		return Objects.equals(name, a.name) && Objects.equals(type, a.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, type);
	}

	@Override
	public String toString() {
		return type + ": " + name;
	}
}
