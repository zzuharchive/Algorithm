import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
  
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == n - 1 && cur[1] == m - 1) 
                return maps[cur[0]][cur[1]];
            
            for(int i=0; i<dx.length; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny <m){
                    if(!visited[nx][ny] && maps[nx][ny] == 1){
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}