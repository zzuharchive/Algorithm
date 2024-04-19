import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] array = new int[N];
		int[] dp = new int[N];
		
		for(int i=0;i<N;i++) {
			array[i] = input.nextInt();
		}
		
		dp[0] = array[0];
		int maxVal = dp[0];
		
		for(int i=1; i<N;i++) {			
			dp[i] = Math.max(Math.max(dp[i-1]+array[i], array[i]),array[i]+array[i-1]);
			maxVal = Math.max(maxVal, dp[i]);
		}
		System.out.println(maxVal);
	}
}
