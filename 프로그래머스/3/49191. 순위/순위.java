import java.util.*;

class Solution {
    public static final int INF = Integer.MAX_VALUE;
    public int solution(int n, int[][] results) {
       
        int[][] d = new int[n+1][n+1];
        
        for(int i = 1; i<d.length; i++){
            for(int j = 1; j< d[i].length; j++){
                if(i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }
        
        for(int[] result : results){
            int win = result[0]; int lose = result[1];
            d[win][lose] = 1;
        }
        
        for(int k = 1; k <= n; k++){ // 경유 노드
            for(int start = 1; start <= n; start++){ // start
                for(int end = 1; end <= n; end++){ // end
                    if(d[start][k] == INF || d[k][end] == INF) continue;
                    d[start][end] = Math.min(d[start][end], d[start][k]+d[k][end]);
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            boolean flag = false;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(d[i][j] == INF && d[j][i] == INF) {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        
        return answer;
    }
}