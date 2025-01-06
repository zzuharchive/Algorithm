import java.util.*;

class Solution {
    
    static ArrayList<int[]> answer = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        int start = 1;
        int tmp = 2;
        int dest = 3;
        
        moveHanoi(n, start, tmp, dest);
       
        return answer.stream()
            .toArray(int[][]::new);
    }
    
    public void moveHanoi(int disc, int start, int tmp, int dest){
        
        if(disc == 0) return;
        
        moveHanoi(disc - 1, start, dest, tmp);
        
        answer.add(new int[]{start, dest});
        
        moveHanoi(disc - 1, tmp, start, dest);
    }
}