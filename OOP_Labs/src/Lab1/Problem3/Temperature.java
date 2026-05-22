package Lab1.Problem3;

public class Temperature {

	public static void main(String[] args) {
		Temp t1 = new Temp(45, 'C');
		System.out.println("45C in F: " + t1.getF());

		Temp t2 = new Temp(12, 'F');
		System.out.println("12F in C: " + t2.getC());

		t1.setBoth(40, 'F');
		System.out.println("New scale: " + t1.getScale() + ", Value in C: " + t1.getC());
	}

}

class Temp {
	private double value;
	private char scale;

	public Temp() {
		this(0, 'C');
	}

	public Temp(char scale) {
		this(0, scale);
	}

	public Temp(double value) {
		this(value, 'C');
	}

	public Temp(double value, char scale) {
		this.value = value;
		this.scale = scale;
	}

	public double getC() {
		if (scale == 'C') {
			return value;
		} else {
			return 5 * (value - 32) / 9;
		}
	}

	public double getF() {
		if (scale == 'F') {
			return value;
		} else {
			return (9 * (value / 5)) + 32;
		}
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setScale(char scale) {
		this.scale = scale;
	}

	public void setBoth(double value, char scale) {
		this.value = value;
		this.scale = scale;
	}

	public char getScale() {
		return this.scale;
	}

}