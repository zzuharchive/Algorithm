import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		
		int N = input.nextInt();
		
		
		for(int i = 0; i < N; i++) {
			list.add(input.nextInt());
		}
		
		Collections.sort(list);
		
		for(int i=0;i<N;i++) {
			stringBuilder.append(list.get(i)).append("\n");
		}
		
		System.out.println(stringBuilder);
	}

}
