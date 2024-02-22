import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int maxX = -10000, minX = 10000;
		int maxY = -10000, minY = 10000;
		
		int N = input.nextInt();
		int[] x = new int[N];
		int[] y = new int[N];
		
		for(int i=0; i < x.length; i++) {
			x[i] = input.nextInt();
			y[i] = input.nextInt();
		}
		
		for(int i = 0; i < x.length; i++) {
			if(maxX < x[i]) maxX = x[i];
			if(minX > x[i]) minX = x[i];
		}
		
		for(int i = 0; i < y.length; i++) {
			if(maxY < y[i]) maxY = y[i];
			if(minY > y[i]) minY = y[i];
		}
		
		System.out.println((maxX - minX) * (maxY - minY) + "");
	}
}
