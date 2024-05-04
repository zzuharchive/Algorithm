import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int n3 = input.nextInt();
		int money = 0;
		int max = 0;

		
		if(n1 == n2) {
			if(n1 == n3){ money = 10000 + n1 * 1000; }
			else {money = 1000 + n1 * 100; }
		}
		else if(n1 != n2) {
			if((n1 == n3) || (n2 == n3)) {
				int same = (n1 == n3) ? n1 : n2;
				money = 1000 + same * 100;}
			else if((n1 != n3) && (n2 != n3)) {
				money = Math.max(n1, n2);
				money = Math.max(money, n3) * 100;
			}
		}
		
		
		System.out.println(money);
	}
}
