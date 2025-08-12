import java.util.*;

class Solution {
    
    Map<String, Integer> countMap = new HashMap<>();
    
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> answer = new ArrayList<>();
        
        for(String order : orders){
            
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            for(int c : course){
                makeCombine(arr, 0, c, new StringBuilder(), countMap);
            }
        }
        
        for(int c : course){
            int maxCount = countMap.entrySet().stream()
                .filter(e->e.getKey().length() == c && e.getValue() >= 2)
                .mapToInt(Map.Entry::getValue)
                .max().orElse(0);
            
            for(Map.Entry<String, Integer> entry : countMap.entrySet()){
                if(entry.getKey().length() == c && entry.getValue() == maxCount)
                    answer.add(entry.getKey());
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
    
    void makeCombine(char[] order, int idx, int length, StringBuilder path, Map<String, Integer> cnt){
        
        if(path.length() == length){
            countMap.merge(path.toString(), 1, Integer::sum);
            return;
        }
        if(idx == order.length) return;
        
        path.append(order[idx]);
        makeCombine(order, idx + 1, length, path, cnt);
        path.deleteCharAt(path.length() - 1);
        
        makeCombine(order, idx + 1, length, path, cnt);     
    }
    
}