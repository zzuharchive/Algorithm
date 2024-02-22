import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String in = input.next();
		int[] num = new int[in.length()];
		int tmp;
		int min = 0;
		
		for(int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(in.charAt(i)+"");
		}
		
		for(int i = num.length-1; i > 0 ; i--) {
			for(int j = 0; j < i; j++) {
				if(num[j]<num[j+1]) {
					tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
				}
			}
		}
		
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
		
	}

}
