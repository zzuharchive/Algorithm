
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		int index = input.nextInt(); 
		System.out.println(str.charAt(index-1));
	}

}
