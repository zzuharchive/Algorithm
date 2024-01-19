import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T=input.nextInt();
		
		for(int i=0;i<T;i++) {
			int R=input.nextInt();
			String S=input.next();
			for(int j=0;j<S.length();j++) {
				for(int k=0;k<R;k++) {
					System.out.print(S.charAt(j));
					if(j==S.length()-1&&k==R-1)System.out.println("");
				}
			}
		
		}
	}

}
