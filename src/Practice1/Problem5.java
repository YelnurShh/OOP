package Practice1;
import java.util.Scanner;
public class Problem5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Your balance: ");
		double balance = in.nextDouble();
		System.out.println("Percent: ");
		double p = in.nextDouble();
		
		System.out.print(balance + (balance * p/100));

	}

}
