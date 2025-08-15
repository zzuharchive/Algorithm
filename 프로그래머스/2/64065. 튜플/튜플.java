import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length()-2);
        
        String[] splited = s.split("(\\},\\{)");
        
        Arrays.sort(splited, (a, b) -> a.length() - b.length());
        Set<Integer> num = new HashSet<>();
        
        int[] answer = new int[splited[splited.length-1].split(",").length];
        int index = 0;
        
        for(String str : splited){
            String[] sp = str.split(",");
            for(int i=0; i<sp.length; i++){
                int cur = Integer.parseInt(sp[i]+"");
                if(num.add(cur)){
                    answer[index++] = cur;
                }
            }
            
        }
             
        return answer;
    }
}