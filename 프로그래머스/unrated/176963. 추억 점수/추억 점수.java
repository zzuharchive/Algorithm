import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        LinkedHashMap<String,Integer>miss=new LinkedHashMap<String, Integer>();
        
        for(int i=0;i<name.length;i++){
            miss.put(name[i], yearning[i]);
        }
        for(int i=0;i<photo.length;i++){
            answer[i]=0;
            for(int j=0;j<photo[i].length;j++){
                if(miss.containsKey(photo[i][j]))
                    answer[i]+=miss.get(photo[i][j]);
            }
        }
        
        return answer;
    }
}