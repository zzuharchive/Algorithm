import static java.lang.Integer.sum;
import static java.lang.Math.max;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] stair = new int[n];
        int[] dpTable = new int[n];

        for (int i = 0; i < n; i++) {
            stair[i] = input.nextInt();
        }

        if (n == 1) {
            System.out.println(stair[0]);
            return;
        } else if (n == 2) {
            System.out.println(sum(stair[0], stair[1]));
            return;
        }

        dpTable[0] = stair[0];
        dpTable[1] = stair[0] + stair[1];
        dpTable[2] = max(stair[0] + stair[2], stair[1] + stair[2]);

        if(n == 3){
            System.out.println(dpTable[2]);
            return;
        }

        for (int i = 3; i < n; i++) {
            dpTable[i] = max(dpTable[i - 3] + stair[i - 1] + stair[i], dpTable[i - 2] + stair[i]);
        }

        System.out.println(dpTable[n - 1]);
    }
}