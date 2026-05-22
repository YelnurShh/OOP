package lab3.problem5;

public class Chocolate implements Comparable<Chocolate> {
	double weight;
	String name;

	Chocolate(String n, double w) {
		name = n;
		weight = w;
	}

	public String toString() {
		return name + "(" + weight + "g)";
	}

	public int compareTo(Chocolate c) {
		return Double.compare(weight, c.weight);
	}
}
