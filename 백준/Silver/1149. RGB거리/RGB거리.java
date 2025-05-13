import static java.lang.Math.min;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int house = input.nextInt();

        int[][] dpTable = new int[house][3];
        int[] R = new int[house];
        int[] G = new int[house];
        int[] B = new int[house];

        for (int i = 0; i < house; i++) {
            R[i] = input.nextInt();
            G[i] = input.nextInt();
            B[i] = input.nextInt();
        }

        dpTable[0][0] = R[0];
        dpTable[0][1] = G[0];
        dpTable[0][2] = B[0];

        for (int i = 1; i < house; i++) {
            dpTable[i][0] = min(dpTable[i - 1][1], dpTable[i - 1][2]) + R[i];
            dpTable[i][1] = min(dpTable[i - 1][0], dpTable[i - 1][2]) + G[i];
            dpTable[i][2] = min(dpTable[i - 1][0], dpTable[i - 1][1]) + B[i];
        }

        int result = min(dpTable[house - 1][0], min(dpTable[house - 1][1], dpTable[house - 1][2]));
        System.out.println(result);
    }
}
