import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextInt()){
			int result = Integer.parseInt(input.next())+Integer.parseInt(input.next());
			System.out.println(result);
		}	

	}

}
