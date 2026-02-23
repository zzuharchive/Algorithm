import java.util.*;
class Solution {
    
    static List<String> dict = new LinkedList<>();
    static String[] vowel = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {

        settingDict("");       
        return dict.indexOf(word) + 1;
    }
    
    void settingDict(String cur){
        
        if(cur.length() > 5) return;
        if(!cur.isEmpty()) dict.add(cur);
        for(int i=0; i<5; i++){
            settingDict(cur + vowel[i]);
        }
        
        
    }
}