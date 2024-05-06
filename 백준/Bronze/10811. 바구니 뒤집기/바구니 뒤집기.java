import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		int left, right =0;
		int[] bucket = new int[n+1];
		
		for(int i=0; i < bucket.length; i++) {
			bucket[i] = i;
		}
		
		for(int j=0;j<m;j++) {
			left = input.nextInt();
			right = input.nextInt();
			
			if(left != right) {
				reverse(bucket, left, right);
			}
		}
		
		for(int i=1; i<bucket.length ;i++) {
			System.out.print(bucket[i]+" ");
		}
		
	}
	static void reverse(int[] bucket, int left, int right) {
		int mid = (left + right)/2;
		for(int i=0;i<mid; i++) {
			if(left >= right) break;
			int tmp = bucket[left];
			bucket[left] = bucket[right];
			bucket[right] = tmp;
			left++;
			right--;
			
		}
	}
}
