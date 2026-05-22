package Lab2.problem1.partA;

public class Sphere extends Shape3D {
	private double r;

	public Sphere(double r) {
		this.r = r;
	}

	@Override
	public double volume() {
		return (4.0 / 3.0) * Math.PI * r * r * r;
	}

	@Override
	public double surfaceArea() {
		return 4 * Math.PI * r * r;
	}
}
