import java.util.*;

class Solution {
    public int solution(String dartResult) {
       
        int playNum = 0;
        int[] scoreRecord = new int[3];
        int i=0;
        
        while(i < dartResult.length()){
            int nowScore = 0;
            if(i+1 < dartResult.length() && dartResult.charAt(i) == '1'  && dartResult.charAt(i+1) == '0'){
                nowScore = 10;
                i += 2;
            } 
            else {
                nowScore = dartResult.charAt(i)-'0';
                i += 1;
            }
            
            if(dartResult.charAt(i) == 'D'){
                nowScore *= nowScore;
            }else if(dartResult.charAt(i) == 'T'){
                nowScore = (int)Math.pow(nowScore, 3);
            }
            
            i++;
            
            if(i < dartResult.length()){
                char option = dartResult.charAt(i);
                if(option == '*'){
                    nowScore *= 2;
                    if(playNum > 0) scoreRecord[playNum - 1] *= 2;
                    i++;
                }else if(option == '#'){
                    nowScore *= -1;
                    i++;
                }
            }
            
            scoreRecord[playNum++] = nowScore;
        }
        
        return scoreRecord[0] + scoreRecord[1] + scoreRecord[2];
    }
}