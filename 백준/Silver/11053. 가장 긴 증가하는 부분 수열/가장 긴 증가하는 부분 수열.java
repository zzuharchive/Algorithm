import static java.lang.Math.max;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[][] dpTable = new int[n][2];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        if (n == 1) {
            System.out.println("1");
            return;
        }

        dpTable[0][0] = 0;
        dpTable[0][1] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    int tempMax = max(dpTable[j][0], dpTable[j][1]);
                    max = max(max, tempMax);
                }
            }
            dpTable[i][0] = max;
            dpTable[i][1] = max + 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = max(result, max(dpTable[i][0], dpTable[i][1]));
        }
        System.out.println(result);
    }
}