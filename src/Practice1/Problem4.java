package Practice1;
import java.util.Scanner;
public class Problem4 {

	public static void main(String[] args) {
		Scanner ax = new Scanner(System.in);

		System.out.println("Enter a: ");
		double a = ax.nextDouble();
		System.out.println("Enter b: ");
		double b = ax.nextDouble();
		System.out.println("Enter c: ");
		double c = ax.nextDouble();
		
		double D = (b*b) - (4*a*c);
		
		if(D < 0) {
			System.out.print("Error");
		}
		else {
			System.out.print(D);
		}
		
	}

}
