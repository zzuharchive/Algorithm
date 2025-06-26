import java.util.*;
class Solution {
   
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
       
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while(!queue.isEmpty()){
            
            int[] cur = queue.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) return cur[2];
            for(int i = 0; i < 4; i++){
                
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(maps[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }   
        
        return -1;
    }
}