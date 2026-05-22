package lab3.problem1;

public abstract class Shape {
	String color;

	Shape(String c) {
		this.color = c;
	}

	abstract double area();

	String getColor() {
		return color;
	}
}
