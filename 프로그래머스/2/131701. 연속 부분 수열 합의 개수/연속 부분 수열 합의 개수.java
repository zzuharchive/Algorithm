import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        
        for(int start = 0; start < elements.length; start++){
            int sum = 0;
            for(int len = 0; len < elements.length; len++){
                int index = (start + len) % elements.length;
                sum += elements[index];
                set.add(sum);
            }
        }
        return set.size();
    }
}