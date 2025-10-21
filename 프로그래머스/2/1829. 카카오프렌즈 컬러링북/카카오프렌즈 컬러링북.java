import java.util.*;
class Solution {
    int numberOfArea;
    int maxSizeOfOneArea;
    boolean[][] visited;
    int[][] board;
    int size;
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        board = picture;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    size = 0;
                    dfs(i, j, picture[i][j]);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
    
    void dfs(int x, int y, int color){
        if(x >= board.length
           || y >= board[0].length 
           || x < 0 || y < 0) return;
        if(visited[x][y] || board[x][y] != color) return;
        
        size++;
        visited[x][y] = true;
        
        dfs(x+1, y, color);
        dfs(x-1, y, color);
        dfs(x, y+1, color);
        dfs(x, y-1, color);
    }
}