import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int num = input.nextInt();
            sum += num;
        }

        System.out.println(sum);
    }
}
