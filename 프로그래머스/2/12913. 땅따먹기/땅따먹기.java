import java.util.*;
class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
 
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 4; j++){
                int max = 0;
                for(int k = 0; k < 4; k++){
                    if(j != k) max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = max + land[i][j];
            }
        }
        
        int answer = 0;
        for(int j = 0; j < 4; j++){
            answer = Math.max(answer, dp[n-1][j]);

        }
        return answer;
    }
}