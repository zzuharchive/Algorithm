import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] student = new int[5];

        int sum = 0;

        for (int i = 0; i < student.length; i++) {
            int score = input.nextInt();
            if (score < 40) score = 40;
            sum += score;
        }

        System.out.println(sum / student.length);
    }
}
