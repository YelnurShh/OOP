package Lab2.problem3;

public class CheckingAccount extends Account {
	private int txCount;
	private static final int FREE_TRANSACTIONS = 3;

	public CheckingAccount(int a) {
		super(a);
		txCount = 0;
	}

	public void deposit(double s) {
		super.deposit(s);
		txCount++;
	}

	public void withdraw(double s) {
		super.withdraw(s);
		txCount++;
	}

	public void deductFee() {
		int excess = txCount - FREE_TRANSACTIONS;
		if (excess > 0)
			super.withdraw(0.02 * excess);
		txCount = 0;
	}

	public int getTxCount() {
		return txCount;
	}

	public String toString() {
		return super.toString() + ", tx=" + txCount;
	}
}
