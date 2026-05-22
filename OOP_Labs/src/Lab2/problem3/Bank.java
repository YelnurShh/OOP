package Lab2.problem3;

import java.util.Vector;

public class Bank {
	private Vector<Account> accounts = new Vector<>();

	public void openAccount(Account a) {
		accounts.add(a);
	}

	public void closeAccount(int num) {
		accounts.removeIf(a -> (int) a.getAccountNumber() == num);
	}

	public void update() {
		for (Account a : accounts) {
			if (a instanceof SavingsAccount)
				((SavingsAccount) a).addInterest();
			else if (a instanceof CheckingAccount)
				((CheckingAccount) a).deductFee();
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("=== Bank ===\n");
		for (Account a : accounts)
			sb.append(a).append("\n");
		return sb.toString();
	}
}
