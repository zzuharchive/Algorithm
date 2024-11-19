import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            int sum = 0;
            for (int j = n; j <= m; j++) {
                String num = j + "";
                int zeroNum = (int) num.chars()
                        .filter(k -> String.valueOf((char) k).equals("0"))
                        .count();

                sum += zeroNum;
            }
            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}
