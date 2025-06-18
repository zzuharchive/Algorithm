import java.util.Scanner;

public class Main {

    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        visited = new boolean[n];
        arr = new int[m];

        dfs(0, n, m);
    }

    public static void dfs(int depth, int n, int m) {
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print((arr[i] + 1) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (depth > 0 && arr[depth - 1] >= i) {
                    continue;
                }
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1, n, m);
                visited[i] = false;
            }
        }
    }
}
