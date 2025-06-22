import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] card = new int[n];
        int sum= 0;

        for (int i = 0; i < n; i++) {
            card[i] = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = card[i] + card[j] + card[k];

                    if (m - temp >= 0) {
                        if (m - temp < m - sum) {
                            sum = temp;
                        }
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
