import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){
            char now = s.charAt(i);
            if(!map.containsKey(now)){
                map.put(now, i);
                answer[i] = -1;
                continue;
            }
            int index = map.get(now);
            answer[i] = i - index;
            map.put(now, i);
        }
        return answer;
    }
}