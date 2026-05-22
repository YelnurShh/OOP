package Lab2.problem1.partA;

public class Cylinder extends Shape3D {
	private double r, h;

	public Cylinder(double r, double h) {
		this.r = r;
		this.h = h;
	}

	@Override
	public double volume() {
		return Math.PI * r * r * h;
	}

	@Override
	public double surfaceArea() {
		return 2 * Math.PI * r * (r + h);
	}
}
