import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String A = input.next();
		String B = input.next();

		long result = 0;
		
		
		for(int i = 0; i<A.length();i++) {
			for(int j = 0; j<B.length();j++) {
				result += Integer.parseInt(A.charAt(i)+"")* 
						Integer.parseInt(B.charAt(j)+"");
			}
		}
		System.out.println(result);
	}

}
