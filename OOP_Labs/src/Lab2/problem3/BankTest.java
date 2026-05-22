package Lab2.problem3;

public class BankTest {
	public static void main(String[] args) {
		Bank bank = new Bank();
		SavingsAccount sa = new SavingsAccount(1001, 5.0);
		CheckingAccount ca = new CheckingAccount(1002);
		Account acc = new Account(1003);

		sa.deposit(1000);
		ca.deposit(500);
		ca.deposit(200);
		ca.withdraw(100);
		ca.withdraw(50);
		acc.deposit(300);

		bank.openAccount(sa);
		bank.openAccount(ca);
		bank.openAccount(acc);

		System.out.println("Before update:");
		System.out.println(bank);

		bank.update();

		System.out.println("After update:");
		System.out.println(bank);

		bank.closeAccount(1003);
		System.out.println("After closing 1003:");
		System.out.println(bank);
	}
}
