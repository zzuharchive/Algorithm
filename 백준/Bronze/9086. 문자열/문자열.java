import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int num = input.nextInt();
		
		for(int i =0; i<num;i++) {
			String str = input.next();
			System.out.println(str.charAt(0)+""+str.charAt(str.length()-1));
		}
	}

}
