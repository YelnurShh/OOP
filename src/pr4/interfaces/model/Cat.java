package pr4.interfaces.model;

public class Cat implements CanHavePizza {
	@Override
	public void eatPizza() {
		System.out.println("Cat eats pizza");
	}
}
