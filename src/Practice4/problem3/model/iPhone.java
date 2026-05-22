package Practice4.problem3.model;

public class iPhone implements SellableAndPluggable {
	@Override
	public void sell() {
		System.out.println("iPhone sold");
	}

	@Override
	public void plug() {
		System.out.println("iPhone plugged");
	}
}
