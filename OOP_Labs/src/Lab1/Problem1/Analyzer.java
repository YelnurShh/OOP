package Lab1.Problem1;

import java.util.Scanner;

public class Analyzer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Data data = new Data();

		while (true) {
			System.out.print("Enter number(to quite 'Q'): ");
			String number = in.next();

			if (number.equalsIgnoreCase("Q")) {
				break;
			}

			try {
				double value = Double.parseDouble(number);
				data.add(value);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a number or 'Q' to quit.");
			}

		}

		System.out.println("AVG: " + data.getAverage());
		System.out.println("MAX: " + data.getLargest());

	}

}
