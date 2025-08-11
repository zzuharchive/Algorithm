import java.util.*;

class Solution {
    Map<String, List<Integer>> applicant = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        
        for(String condition : info){
            String[] sp = condition.split(" ");
            String[] attrs = {sp[0], sp[1], sp[2], sp[3]};
            int score = Integer.parseInt(sp[4]);
            getAllCombos(attrs, score);
        }
        
        for(List<Integer> list : applicant.values())
            Collections.sort(list);
        
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++){
            String q = query[i].replace(" and ", " ");
            String[] sp = q.split(" ");
            String key = makeKey(sp[0], sp[1], sp[2], sp[3]);
            int thresholdScore = Integer.parseInt(sp[4]);
            
            List<Integer> list = applicant.getOrDefault(key, Collections.emptyList());
            int idx = lowerBound(list, thresholdScore);
            answer[i] = list.size() - idx;
        }
        
        return answer;
    }
    
    void getAllCombos(String[] attrs, int score){
        
        for(int mask = 0; mask < 16; mask++){
            String language = ((mask & 8) != 0) ? "-" : attrs[0];
            String position = ((mask & 4) != 0) ? "-" : attrs[1];
            String history = ((mask & 2) != 0) ? "-" : attrs[2];
            String food = ((mask & 1) != 0) ? "-" : attrs[3];
            String key = makeKey(language, position, history, food);
            applicant.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
        }
    }
    
    String makeKey(String language, String position, String history, String food){
        
        return language +" "+ position +" "+history+" "+food;
    }
    
    int lowerBound(List<Integer> list, int target){
        int low = 0;
        int high = list.size();
        while(low < high){
            int mid = (low + high) >>> 1;
            if(list.get(mid) >= target) high = mid;
            else low = mid + 1; 
        }
        return low;
    }
}