import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int orgNum = input.nextInt();
		int num=0;
		int cycle = 0;
		int ten = orgNum / 10;
		int one = orgNum % 10;
		int result = 0;
		while(true) {
			result = ten + one;
			cycle++;
			
			int resOne = (result>=10)?result % 10 : result;
			num = one*10 + resOne;
			if(num==orgNum) break;
			
			ten = num / 10;
			one = num %10;
		}
		System.out.println(cycle);
	}

}
