import java.util.Scanner;

public class Main {
	static void bubbleSort(int[] num) {
		int tmp;
		for(int i=0; i < num.length; i++) {
			for(int j=1; j < num.length-i; j++) {
				if(num[j-1] < num[j]) {
					tmp = num[j];
					num[j] = num[j-1];
					num[j-1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int k = input.nextInt();
		int num[] = new int[N];
		
		for(int i=0; i<N; i++) {
			num[i] = input.nextInt();
		}
		
		bubbleSort(num);
		System.out.println(num[k-1]);
	}

}
