import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arrays = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arrays[i][0] = Integer.parseInt(st.nextToken());
			arrays[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrays,(num1, num2)->{
			return num1[0]!=num2[0] ? num1[0]-num2[0]:num1[1]-num2[1];
		});
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<N;i++) {
			sb.append(arrays[i][0]).append(" ").append(arrays[i][1]).append("\n");
		}
		
		System.out.println(sb);
	}

}