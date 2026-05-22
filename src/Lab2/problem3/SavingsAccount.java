package Lab2.problem3;
public class SavingsAccount extends Account {
	private double rate;

	public SavingsAccount(int a, double r) {
		super(a);
		rate = r;
	}

	public void addInterest() {
		deposit(getBalance() * rate / 100);
	}

	public double getRate() {
		return rate;
	}

	public String toString() {
		return super.toString() + ", rate=" + rate + "%";
	}
}
