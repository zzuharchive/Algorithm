import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        
        for(int index=0; index<nums.length; index++){

            int size = answer.size();
           
            for(int j = 0; j<size; j++){
                // 이미 만들어져 있는 조합에 새로운 숫자를 넣는다
                List<Integer> tmp = new ArrayList<>(answer.get(j));  
                tmp.add(nums[index]);
                answer.add(tmp);
            }
        }

        return answer;
    }
}