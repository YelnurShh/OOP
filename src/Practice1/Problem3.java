package Practice1;
import java.util.Scanner;
public class Problem3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your grade: ");
		double grade = in.nextDouble();
		
		
			if(grade == 49.5 || grade < 54.5) {
				System.out.print("D");
				
			}			
			else if(grade == 54.5 || grade < 59.5) {
				System.out.print("D+");
				
			}			
			else if(grade == 59.5 || grade < 64.5) {
				System.out.print("C-");
				
			}			
			else if(grade == 64.5 || grade < 69.5) {
				System.out.print("C");
				
			}			
			else if(grade == 69.5 || grade < 74.5) {
				System.out.print("C+");
				
			}
			else if(grade == 74.5 || grade < 79.5) {
				System.out.print("B-");
				
			}
			else if(grade == 79.5 || grade < 84.5) {
				System.out.print("B");
				
			}
			else if(grade == 84.5 || grade < 89.5) {
				System.out.print("B+");
				
			}
			else if(grade == 89.5 || grade < 94.5) {
				System.out.print("A-");
				
			}
			else if(grade == 94.5 || grade <=100) {
				System.out.print("A");
				
			}
			else {
				System.out.print("F");
			}
			

	}

}
