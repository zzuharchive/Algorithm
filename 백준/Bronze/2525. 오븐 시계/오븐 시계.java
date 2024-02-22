import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();
		int exp;
		
		B += C;
		exp = (A + B / 60); 
		A = ( exp >= 24) ? exp - 24 : exp;  
		
		System.out.println( A + " " + (B % 60));
	}

}
