import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        
        int n = 0;
        for(int[] e : edges){
            n = Math.max(n, e[0]);
            n = Math.max(n, e[1]);
        }
        
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        
        for(int[] e : edges){
            out[e[0]]++;
            in[e[1]]++;
        }
        
        int[] answer = new int[4];
      
        for(int i=1; i<=n; i++){
          
            if(in[i] == 0 && out[i] >= 2){
                answer[0] = i;
            }else{
                if(in[i] >= 1 && out[i] == 0){ // 막대
                answer[2]++;
                }
                if(out[i] == 2){ // 8자
                    answer[3]++;
                }   
            }
        }
        
        answer[1] = out[answer[0]] - (answer[2] + answer[3]); // 도넛
        
        return answer;
    }
}