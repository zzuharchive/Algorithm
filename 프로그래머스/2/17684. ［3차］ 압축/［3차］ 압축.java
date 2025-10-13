import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> dict = new HashMap<>();
        
        // 기본 사전 초기화
        for(int i = 0; i < 26; i++){
            int alphabet = (int)'A' + i; 
            dict.put((char)alphabet+"", i+1);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<msg.length(); i++){
            
            StringBuilder str = new StringBuilder();   
            str.append(msg.charAt(i));
            int printIdx = dict.get(str.toString());
            
            for(int j = i + 1; j<msg.length(); j++){
                str.append(msg.charAt(j));
                int idx = dict.getOrDefault(str.toString(), 0);
                if(idx == 0){
                    dict.put(str.toString(), dict.size() + 1);
                    break;
                } else{
                    printIdx = idx;
                    i = j;
                }
            }
            answer.add(printIdx);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}