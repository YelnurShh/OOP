package pr5.io.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("x1: ");
                int x1 = Integer.parseInt(sc.nextLine().trim());
                System.out.print("x2: ");
                int x2 = Integer.parseInt(sc.nextLine().trim());
                System.out.println("= " + (x1 / x2));
            } catch (ArithmeticException e) {
                System.out.println("Error: division by zero");
            } catch (NumberFormatException e) {
                System.out.println("Error: not a number");
            }
            System.out.print("Try again? (y/n): ");
            if (!sc.nextLine().trim().equalsIgnoreCase("y")) break;
        }
        sc.close();
    }
}
