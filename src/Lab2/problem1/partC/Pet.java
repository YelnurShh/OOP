package Lab2.problem1.partC;

import java.util.Objects;

public class Pet extends Animal {
	private String owner;

	public Pet(String name, String type, String owner) {
		super(name, type);
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		if (!(o instanceof Pet))
			return false;
		Pet p = (Pet) o;
		return Objects.equals(owner, p.owner);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), owner);
	}

	@Override
	public String toString() {
		return super.toString() + ", owner: " + owner;
	}
}
