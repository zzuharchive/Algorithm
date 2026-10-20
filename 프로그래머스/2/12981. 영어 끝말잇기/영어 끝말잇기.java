import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            char last = words[i-1].charAt(words[i-1].length() - 1);
            char cur = words[i].charAt(0);
            if(set.contains(words[i]) || last != cur){
                return new int[]{i%n+1, i/n+1};
            }
            set.add(words[i]);
        }
        
        return new int[]{0, 0};
    }
}