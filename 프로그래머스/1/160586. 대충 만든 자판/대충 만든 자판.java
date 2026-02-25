import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> keyNum = new HashMap<>();
       
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                // 이미 저장된 경우 -> 더 작은 값으로 저장
                int num = 0;
                char cur = keymap[i].charAt(j);
                if(keyNum.containsKey(cur)){
                    num = keyNum.get(cur);
                    keyNum.put(cur, Math.min(j+1, num));
                }
                // 없는 경우 -> 저장
                else{
                    keyNum.put(cur, j+1);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            int result = 0;
            for(int j=0; j<targets[i].length(); j++){
                int now = keyNum.getOrDefault(targets[i].charAt(j), -1);
                if(now == -1){
                    result = -1;
                    break;
                }else{
                    result += now;
                }
            }
            answer[i] = result;
        }
        
        return answer;
    }
}