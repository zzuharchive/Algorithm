import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        arr = new int[m];

        dfs(0, n, m);
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int n, int m) throws IOException {
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                bw.write((arr[i] + 1) + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            dfs(depth + 1, n, m);
        }
    }
}