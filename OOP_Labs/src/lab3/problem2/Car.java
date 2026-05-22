package lab3.problem2;

public class Car implements Moveable {
	double x, y;
	String n;

	Car(String n, double x, double y) {
		this.n = n;
		this.x = x;
		this.y = y;
	}

	public void move(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public String toString() {
		return n + " at (" + x + "," + y + ")";
	}
}
