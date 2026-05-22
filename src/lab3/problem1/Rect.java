package lab3.problem1;

public class Rect extends Shape {
	double w, h;

	Rect(String c, double w, double h) {
		super(c);
		this.w = w;
		this.h = h;
	}

	double area() {
		return w * h;
	}
}
