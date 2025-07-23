import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        String answer = "";
        
        char[][] indicator = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<survey.length; i++){
            String who = "";
            if(choices[i] > 4){
                who += survey[i].charAt(1);
                int score = choices[i] - 4;
                map.put(who, map.getOrDefault(who, 0) + score);
            }else if(choices[i] < 4){
                who += survey[i].charAt(0);
                int score = 4 - choices[i];
                map.put(who, map.getOrDefault(who, 0) + score);
            }else {
                continue;
            }
        }
        
        
        for(int i=0; i<indicator.length; i++){   
            if(map.getOrDefault(indicator[i][0]+"", 0) > map.getOrDefault(indicator[i][1]+"", 0)){
                answer += indicator[i][0];
            }else if(map.getOrDefault(indicator[i][0]+"", 0) < map.getOrDefault(indicator[i][1]+"", 0)){
                answer += indicator[i][1];
            }else{
                answer += (indicator[i][0]<indicator[i][1])?indicator[i][0]:indicator[i][1];
            }
        }
        
        return answer;
    }
}