package models;

import java.io.Serializable;
import java.util.Objects;

public class Mark implements Serializable, Comparable<Mark> {
	private static final long serialVersionUID = 1L;

	private double firstAtt;
	private double secondAtt;
	private double finalExam;

	public Mark() {
		this.firstAtt = 0;
		this.secondAtt = 0;
		this.finalExam = 0;
	}

	public Mark(double f, double s, double fin) {
		this.firstAtt = f;
		this.secondAtt = s;
		this.finalExam = fin;
	}

	public double getFirstAtt() {
		return firstAtt;
	}

	public double getSecondAtt() {
		return secondAtt;
	}

	public double getFinalExam() {
		return finalExam;
	}

	public void setFirstAtt(double v) {
		this.firstAtt = v;
	}

	public void setSecondAtt(double v) {
		this.secondAtt = v;
	}

	public void setFinalExam(double v) {
		this.finalExam = v;
	}

	public double getTotal() {
		return firstAtt + secondAtt + finalExam;
	}

	public boolean isFailed() {
		return getTotal() < 50;
	}

	public String getLetter() {
		double t = getTotal();
		if (t >= 95)
			return "A";
		if (t >= 90)
			return "A-";
		if (t >= 85)
			return "B+";
		if (t >= 80)
			return "B";
		if (t >= 75)
			return "B-";
		if (t >= 70)
			return "C+";
		if (t >= 65)
			return "C";
		if (t >= 60)
			return "C-";
		if (t >= 55)
			return "D+";
		if (t >= 50)
			return "D";
		return "F";
	}

	@Override
	public int compareTo(Mark o) {
		return Double.compare(this.getTotal(), o.getTotal());
	}

	@Override
	public String toString() {
		return String.format("Att1=%.1f, Att2=%.1f, Final=%.1f, Total=%.1f (%s)", firstAtt, secondAtt, finalExam,
				getTotal(), getLetter());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Mark))
			return false;
		Mark m = (Mark) o;
		return Double.compare(m.firstAtt, firstAtt) == 0 && Double.compare(m.secondAtt, secondAtt) == 0
				&& Double.compare(m.finalExam, finalExam) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstAtt, secondAtt, finalExam);
	}
}
