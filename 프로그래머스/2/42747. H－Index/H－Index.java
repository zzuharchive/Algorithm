import java.util.*;

class Solution {
    public int solution(int[] citations) {
       
        Arrays.sort(citations);
        
        
        for(int i=0; i<citations.length; i++){
            int n = citations.length - i;
            if(citations[i] >= n) return n;
        }
        return 0;
    }
}