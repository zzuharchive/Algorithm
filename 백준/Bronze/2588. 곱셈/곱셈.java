import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		long value = 0;
		String toString = Integer.toString(b);
		
		for(int i = toString.length() - 1, j = 0; i >= 0 ; i--) {
			int parse = Integer.parseInt(toString.charAt(i) + "");
			int origin = parse * (int)Math.pow(10, j);
			System.out.println(a * parse);
			value += (a * origin);
			j++;
		}
		System.out.println(value);

	}

}
