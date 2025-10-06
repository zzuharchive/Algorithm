import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder str = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        int num = 0;
        
        while(str.length() < t * m){
            str.append(Integer.toString(num, n).toUpperCase());
            num ++;
        }
        
        int index = p - 1;
        
        while(answer.length() < t){
            answer.append(str.charAt(index));
            index += m;
        }
        return answer.toString();
    }
}