import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] alphabet = new char[name.length()];
        Arrays.fill(alphabet, 'A');
        
        int move = name.length() - 1;
        
        for(int i=0; i<name.length(); i++){
            
            // 알파벳 정하기(상하)
            int sub = name.charAt(i) - alphabet[i];
            answer += Math.min(sub, 26 - sub);
            
            // 커서 위치 이동(좌우)
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A'){
                next++;
            }
            
            move = Math.min(move, i*2 + name.length()-next);
            move = Math.min(move, (name.length()-next)*2 + i);
           
        }
        
        answer += move;
        return answer;
    }
}