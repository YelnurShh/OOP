package Lab2.problem1.partA;

public class ShapeTest {
	public static void main(String[] args) {
		Shape3D c = new Cylinder(3, 5);
		Shape3D s = new Sphere(4);
		Shape3D cu = new Cube(2);

		System.out.println("Cylinder volume: " + c.volume());
		System.out.println("Cylinder surface: " + c.surfaceArea());
		System.out.println("Sphere volume: " + s.volume());
		System.out.println("Sphere surface: " + s.surfaceArea());
		System.out.println("Cube volume: " + cu.volume());
		System.out.println("Cube surface: " + cu.surfaceArea());
	}
}
