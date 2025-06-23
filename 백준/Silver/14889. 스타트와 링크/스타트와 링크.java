import java.util.Scanner;

public class Main {

    static boolean[] visited;
    static int n;
    static int[][] ability;
    static int minimum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        ability = new int[n][n];

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ability[i][j] = input.nextInt();
            }
        }

        dfs(0, 0);
        System.out.println(minimum);
    }

    static void dfs(int depth, int start) {
        if (depth == n / 2) {
            calculate();
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void calculate() {
        int startSum = 0;
        int linkSum = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // start
                if (visited[i] && visited[j]) {
                    startSum += ability[i][j] + ability[j][i];
                }
                // link
                else if (!visited[i] && !visited[j]) {
                    linkSum += ability[i][j] + ability[j][i];
                }
            }
        }

        minimum = Math.min(minimum, Math.abs(startSum - linkSum));
    }
}
