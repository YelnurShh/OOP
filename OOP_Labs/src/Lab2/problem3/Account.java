package Lab2.problem3;

public class Account {
	private double balance;
	private int accNum;

	public Account(int a) {
		balance = 0.0;
		accNum = a;
	}

	public void deposit(double s) {
		if (s > 0)
			balance += s;
	}

	public void withdraw(double s) {
		if (s > 0 && s <= balance)
			balance -= s;
	}

	public double getBalance() {
		return balance;
	}

	public double getAccountNumber() {
		return accNum;
	}

	public void transfer(double amt, Account other) {
		withdraw(amt);
		other.deposit(amt);
	}
	
	
	public String toString() {
		return "Account[" + accNum + "] balance=" + String.format("%.2f", balance);
	}

	public final void print() {
		System.out.println(toString());
	}
}
