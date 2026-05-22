package lab3.problem1;

public class Problem1 {
	public static void main(String[] args) {
		System.out.println("=== Abstract class: shared state + partial implementation ===");
		Circle c = new Circle("red", 5);
		Rect r = new Rect("blue", 3, 4);
		System.out.println("Circle area: " + c.area() + ", color: " + c.getColor());
		System.out.println("Rect area: " + r.area() + ", color: " + r.getColor());

		System.out.println("\n=== Interface: contract for unrelated classes, multiple inheritance ===");
		DrawableCircle dc = new DrawableCircle("green", 10);
		dc.draw();
		dc.resize(0.5);
		dc.draw();
	}
}
