import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = new String();
		
		while(input.hasNextLine()){			
			str = input.nextLine();
			System.out.println(str);
		}

	}
}
