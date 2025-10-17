import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++) map[i] = board[i].toCharArray();
        
        int answer = 0;
        while(true){
            boolean[][] remove = new boolean[m][n];
            boolean isChanged = false;
            
            for(int i=0; i < m - 1; i++){
                for(int j = 0 ; j < n - 1; j++){
                    char block = map[i][j];
                    if(block != '.' 
                      && map[i][j+1] == block
                      && map[i+1][j] == block 
                      && map[i+1][j+1] == block){
                        
                        remove[i][j] = true;
                        remove[i][j+1] = true;
                        remove[i+1][j] = true;
                        remove[i+1][j+1] = true;
                        
                        isChanged = true;
                    }
                }
            }
                    
            if(!isChanged) break;
                    
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(remove[i][j]) {
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }
                    
            for(int i = 0; i < n; i++){
                int emptyIdx = m - 1;
                for(int j = m - 1; j >= 0; j--){
                    if(map[j][i] != '.'){
                        char tmp = map[j][i];
                        map[j][i] = '.';
                        map[emptyIdx][i] = tmp;
                        emptyIdx--;
                    }
                }
            }
        }
        
        return answer;
    }
}