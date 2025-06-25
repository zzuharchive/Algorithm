import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int choiceNum = nums.length/2;
        
        HashMap<Integer, Integer> phoneketmon = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length;i++){
            if(phoneketmon.containsKey(nums[i])){
                phoneketmon.replace(nums[i], phoneketmon.get(nums[i] + 1));
            }else{
                phoneketmon.put(nums[i], 1);
            }
        }
        
        answer = (choiceNum>phoneketmon.size()) ? phoneketmon.size() : choiceNum;
        
        return answer;
    }
}