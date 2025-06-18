import java.util.Scanner;

public class Main {

    static int n;
    static int answer;
    static int[] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        arr = new int[n];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean can = true;
            if (row > 0) {

                for (int j = 0; j < row; j++) {
                    if (arr[j] == i || Math.abs(row - j) == Math.abs(i - arr[j])) {
                        can = false;
                        break;
                    }
                }
            }
            if (!can) {
                continue;
            }
            arr[row] = i;
            dfs(row + 1);
        }
    }
}