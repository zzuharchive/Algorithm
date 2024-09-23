import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> arrList = new ArrayList<>();
        
        arrList.add(arr[0]);
        
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=arr[i-1]) arrList.add(arr[i]);
        }
        
        answer = arrList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}