package lab3.problem1;

public class DrawableCircle extends Circle implements Drawable, Resizable {
	DrawableCircle(String c, double r) {
		super(c, r);
	}

	public void draw() {
		System.out.println("Drawing circle r=" + r + " color=" + color);
	}

	public void resize(double f) {
		r *= f;
	}
}
