package Lab2.problem4;

public class Parallel extends Circuit {
	private Circuit a, b;

	public Parallel(Circuit a, Circuit b) {
		this.a = a;
		this.b = b;
	}

	public double getResistance() {
		return 1.0 / (1.0 / a.getResistance() + 1.0 / b.getResistance());
	}

	public double getPotentialDiff() {
		return a.getPotentialDiff();
	}

	public void applyPotentialDiff(double v) {
		a.applyPotentialDiff(v);
		b.applyPotentialDiff(v);
	}
}
