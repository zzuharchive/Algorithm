import java.util.*;
class Solution {
    int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        dp = new int[triangle.length][triangle.length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recursive(triangle, 0, 0);
    }
    public int recursive(int[][] triangle, int x, int y){
        if(x == triangle.length - 1) return triangle[x][y];
        if(dp[x][y] != -1) return dp[x][y];
        
        int left = recursive(triangle, x+1, y);
        int right = recursive(triangle, x+1, y+1);
        dp[x][y] = Math.max(left, right) + triangle[x][y];
        return dp[x][y];
    }
}