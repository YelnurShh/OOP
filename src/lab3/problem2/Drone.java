package lab3.problem2;

public class Drone implements Flyable {
	double x, y, z;
	String n;

	Drone(String n, double x, double y, double z) {
		this.n = n;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void move(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public void fly(double dz) {
		z += dz;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public String toString() {
		return n + " at (" + x + "," + y + "," + z + ")";
	}
}
