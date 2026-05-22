package Practice1;
import java.util.Scanner;
public class Problem6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input your word: ");
		String soz = in.nextLine();
		
		StringBuilder zos = new StringBuilder(soz);
		zos.reverse();
		String rsoz = zos.toString();
		
		if(soz.equals(rsoz)) {
			System.out.print("Yes it is palindrome");
		}
		else {
			System.out.print("No it is not palindrome");
		}

	}

}
