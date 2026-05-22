package Lab2.problem4;

public class Resistor extends Circuit {
	private double r, v;

	public Resistor(double r) {
		this.r = r;
	}

	public double getResistance() {
		return r;
	}

	public double getPotentialDiff() {
		return v;
	}

	public void applyPotentialDiff(double v) {
		this.v = v;
	}
}
