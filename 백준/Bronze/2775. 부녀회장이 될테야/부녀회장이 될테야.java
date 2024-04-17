import java.util.Scanner;

public class Main {
	public static int apartment(int k, int n) {
		int[][] population = new int[15][15];
	
		for(int i = 1; i<=14 ;i++) {
			population[0][i] = i;
		}
		
		for(int i=1;i<=14;i++) {
			for(int j=1; j<=14;j++) {
				population[i][j] = population[i-1][j]+population[i][j-1];
			}
		}
		return population[k][n];
		
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		int k, n;
		for(int i = 0; i < T; i++) {
			k = input.nextInt();
			n = input.nextInt();
			System.out.println(apartment(k,n));
		}
		
		
	}
}
