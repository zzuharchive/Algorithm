import java.util.Scanner;

public class Main {
	//선택정렬 메서드
	static void selectionSort(int[] num) {
		int tmp, tmpIndex=0;
		
		for(int i=0; i<num.length; i++) {
			int least = num[i];
			for(int j = i; j < num.length; j++) {
				if(num[j] < least) {
					least = num[j];
					tmpIndex = j;
					}
				}
			tmp = num[i];
			num[i] = least;
			num[tmpIndex] = tmp;
		}
	}
	//메인메서드
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int []num = new int[5];
		int sum=0;
		
		for(int i=0;i<num.length;i++) {
			num[i] = input.nextInt();
			sum+=num[i];
		}
		
		selectionSort(num);
		
		System.out.println(sum/num.length);
		System.out.println(num[num.length/2]);
		
	}

}
