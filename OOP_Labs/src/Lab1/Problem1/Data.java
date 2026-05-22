package Lab1.Problem1;

import java.util.Scanner;

public class Data {

	private double sumA;
	private double maxA;
	private int countA;

	public Data() {
		this.sumA = 0;
		this.maxA = Double.NEGATIVE_INFINITY;
		this.countA = 0;
	}

	public void add(double value) {
		sumA += value;
		countA++;

		if (value > maxA) {
			maxA = value;
		}
	}

	public double getAverage() {
		if (countA == 0)
			return 0;
		return this.sumA / this.countA;
	}

	public double getLargest() {
		if (countA == 0)
			return 0;
		return maxA;
	}

}
