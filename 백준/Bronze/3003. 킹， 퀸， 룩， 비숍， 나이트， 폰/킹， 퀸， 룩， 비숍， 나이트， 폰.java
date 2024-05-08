import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int king = 1 - input.nextInt();
		int queen = 1 - input.nextInt();
		int rook = 2 - input.nextInt();
		int bishop = 2 - input.nextInt();
		int knight = 2 - input.nextInt();
		int pawn = 8 - input.nextInt();
		
		System.out.print(king +" "+queen +" "+rook+" "+bishop+" "+knight+" "+pawn);
		
	}

}
