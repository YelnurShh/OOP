package Practice1;
import java.util.Scanner;
public class PrintMyName {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input your name: ");
		String name = input.nextLine();
		
		String line = "-";
		
		line = line.repeat(name.length());
		
		System.out.println("+" + line + "+");
		System.out.println("|" + name + "|");
		System.out.println("+" + line + "+");
		
	}

}
