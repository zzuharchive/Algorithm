import java.util.*;
class Solution {
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        backtracking(k, dungeons, 0);
        return answer;
    }
    void backtracking(int k, int[][] dungeons, int dnum){
        
        answer = Math.max(answer, dnum);
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            
            if(k >= dungeons[i][0]){
                visited[i] = true;
                backtracking(k - dungeons[i][1], dungeons, dnum + 1);
                visited[i] = false;
            }
        }
    }
}