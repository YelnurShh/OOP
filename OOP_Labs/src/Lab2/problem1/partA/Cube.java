package Lab2.problem1.partA;

public class Cube extends Shape3D {
	private double s;

	public Cube(double s) {
		this.s = s;
	}

	@Override
	public double volume() {
		return s * s * s;
	}

	@Override
	public double surfaceArea() {
		return 6 * s * s;
	}
}
