import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int cnt=0;
		
		int attempts = input.nextInt();
		for(int i=0; i<attempts; i++) {
			int[] alphabet = new int[26];
			String str = input.next();
			for(int j=0; j<str.length();j++) {
				if(alphabet[str.charAt(j)-97]>=1) {
					if(str.charAt(j)!=str.charAt(j-1))
						break;
				}
				
				else alphabet[str.charAt(j)-97]++;
				if(j==str.length()-1) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
