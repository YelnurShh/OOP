package lab3.problem5;

public class Time implements Comparable<Time> {
	int h, m, s;

	Time(int h, int m, int s) {
		this.h = h;
		this.m = m;
		this.s = s;
	}

	int toSec() {
		return h * 3600 + m * 60 + s;
	}

	public String toString() {
		return String.format("%02d:%02d:%02d", h, m, s);
	}

	public int compareTo(Time t) {
		return Integer.compare(toSec(), t.toSec());
	}
}
