package academic;

import java.io.Serializable;
import java.util.Objects;

public class Mark implements Serializable {

	private static final long serialVersionUID = 1L;

	private double firstAttestation;
	private double secondAttestation;
	private double finalExam;

	public Mark() {
	}

	public Mark(double firstAttestation, double secondAttestation, double finalExam) {
		this.firstAttestation = firstAttestation;
		this.secondAttestation = secondAttestation;
		this.finalExam = finalExam;
	}

	public double getTotal() {
		return (firstAttestation * 0.3) + (secondAttestation * 0.3) + (finalExam * 0.4);
	}

	public double getFirstAttestation() {
		return firstAttestation;
	}

	public void setFirstAttestation(double firstAttestation) {
		this.firstAttestation = firstAttestation;
	}

	public double getSecondAttestation() {
		return secondAttestation;
	}

	public void setSecondAttestation(double secondAttestation) {
		this.secondAttestation = secondAttestation;
	}

	public double getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Mark))
			return false;
		Mark that = (Mark) o;
		return Double.compare(that.firstAttestation, firstAttestation) == 0
				&& Double.compare(that.secondAttestation, secondAttestation) == 0
				&& Double.compare(that.finalExam, finalExam) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstAttestation, secondAttestation, finalExam);
	}

	@Override
	public String toString() {
		return "Mark{1st=" + firstAttestation + ", 2nd=" + secondAttestation + ", final=" + finalExam + ", total="
				+ getTotal() + "}";
	}
}
