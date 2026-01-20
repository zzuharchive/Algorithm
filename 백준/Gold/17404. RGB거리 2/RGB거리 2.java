import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    static final int INF = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                cost[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[][] dp = new int[n][3];
        dp[0][R] = cost[0][R];
        dp[0][G] = cost[0][G];
        dp[0][B] = cost[0][B];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int lowCost = Integer.MAX_VALUE;
            if (i == R) {
                dp[0][R] = cost[0][R];
                dp[0][G] = INF;
                dp[0][B] = INF;
            } else if (i == G) {
                dp[0][R] = INF;
                dp[0][G] = cost[0][G];
                dp[0][B] = INF;
            } else if (i == B) {
                dp[0][R] = INF;
                dp[0][G] = INF;
                dp[0][B] = cost[0][B];
            }

            for (int j = 1; j < n; j++) {
                dp[j][R] = cost[j][R] + Math.min(dp[j - 1][G], dp[j - 1][B]);
                dp[j][G] = cost[j][G] + Math.min(dp[j - 1][R], dp[j - 1][B]);
                dp[j][B] = cost[j][B] + Math.min(dp[j - 1][R], dp[j - 1][G]);
            }
            if (i == R) {
                lowCost = Math.min(dp[n - 1][G], dp[n - 1][B]);
            } else if (i == G) {
                lowCost = Math.min(dp[n - 1][R], dp[n - 1][B]);
            } else if (i == B) {
                lowCost = Math.min(dp[n - 1][R], dp[n - 1][G]);
            }
            answer = Math.min(answer, lowCost);
        }
        System.out.println(answer);
    }
}
