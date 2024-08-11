import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> num = new HashMap<>();
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        String sum = (a * b * c) + "";

        for (int i = 0; i < 10; i++) {
            num.put(i + "", 0);
        }

        for (int i = 0; i < sum.length(); i++) {
            String number = sum.charAt(i) + "";
            num.replace(number, num.get(number) + 1);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(num.get(i + ""));
        }

    }
}
