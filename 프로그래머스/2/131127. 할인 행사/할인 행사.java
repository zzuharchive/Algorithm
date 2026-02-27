import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
       
        Map<String, Integer> wantMap = new HashMap<>();
        int answer = 0;
        
        for(int i=0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        for(int i=0; i <= discount.length - 10; i++){
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < 10; j++){
                map.put(discount[i + j], map.getOrDefault(discount[i + j], 0) + 1);
            }
            for(int j = 0; j < want.length; j++){
                if(map.getOrDefault(want[j], 0) != wantMap.get(want[j])) break;
                if(j == want.length - 1) answer ++;
            }
        }
        
        return answer;
    }
}