package Practice1;

import java.util.Scanner;


public class Problem2 {

	public static void main(String[] args) {
		Scanner side = new Scanner(System.in);
		
		System.out.print("Input side(int): ");
		
		int a = side.nextInt();
		
		double b = a;
		
		System.out.println("Area:" + a*a);
		System.out.println("Perimetr:" + a*4);
		System.out.println("Diogonal:" + b*Math.sqrt(2));
		
	}

}
