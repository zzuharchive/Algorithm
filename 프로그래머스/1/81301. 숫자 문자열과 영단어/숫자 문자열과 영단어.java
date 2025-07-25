import java.util.*;
class Solution {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                String eng = s.charAt(i)+"";
                for(int j=i+1; j < s.length(); j++){
                    eng += s.charAt(j)+"";
                    if(map.containsKey(eng)){
                        answer+= map.get(eng)+"";
                        i = (j == s.length()-1)? s.length() : j; 
                        break;
                    }
                }
            }else{
                answer += s.charAt(i)+"";
            }
        }

        return Integer.parseInt(answer);
    }
}