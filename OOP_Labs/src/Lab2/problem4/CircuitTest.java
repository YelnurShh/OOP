package Lab2.problem4;

public class CircuitTest {
	public static void main(String[] args) {
		Circuit r1 = new Resistor(7.0);
		Circuit r2 = new Resistor(10.0);
		Circuit r3 = new Resistor(6.0);
		Circuit r4 = new Resistor(4.0);
		Circuit c1 = new Parallel(r1, r2);
		Circuit c2 = new Series(r3, r4);
		Circuit circuit = new Parallel(c1, c2);
		circuit.applyPotentialDiff(24.0);
		double R = circuit.getResistance();
		System.out.printf("R = %.4f Ohm%n", R);
		System.out.printf("I = %.4f A%n", circuit.getCurrent());
		System.out.printf("P = %.4f W%n", circuit.getPower());
	}
}
