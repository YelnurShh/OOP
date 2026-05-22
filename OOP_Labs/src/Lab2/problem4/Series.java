package Lab2.problem4;

public class Series extends Circuit {
	private Circuit a, b;

	public Series(Circuit a, Circuit b) {
		this.a = a;
		this.b = b;
	}

	public double getResistance() {
		return a.getResistance() + b.getResistance();
	}

	public double getPotentialDiff() {
		return a.getPotentialDiff() + b.getPotentialDiff();
	}

	public void applyPotentialDiff(double v) {
		double r = getResistance();
		a.applyPotentialDiff(v * a.getResistance() / r);
		b.applyPotentialDiff(v * b.getResistance() / r);
	}
}
