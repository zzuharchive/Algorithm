import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> by = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        Map<String, Integer> numCount = new HashMap<>();  
        
        for(int i=0; i<id_list.length; i++){
            index.put(id_list[i], i);
        }
        for(int i=0; i<report.length; i++){
            String[] splited = report[i].split(" ");
            List<String> list = by.getOrDefault(splited[1], new ArrayList<>());
            if(!list.contains(splited[0])){
                list.add(splited[0]);
                by.put(splited[1], list);
                numCount.put(splited[1], numCount.getOrDefault(splited[1], 0) + 1);
            }
            by.get(splited[1]).size();
        }
        
        for(int i=0; i<id_list.length; i++){
            int num = numCount.getOrDefault(id_list[i], 0);
           
            if(num >= k){
                List<String> list = by.getOrDefault(id_list[i], new ArrayList<>());
         
                for(int j = 0; j<list.size(); j++){
               
                    answer[index.get(list.get(j))]++;
                }
            }
        }
        return answer;
    }
}