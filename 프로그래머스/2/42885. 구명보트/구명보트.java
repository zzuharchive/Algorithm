import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int right = people.length - 1;
        int left = 0;
        
        while(left <= right){
            answer++;
            if(limit >= people[left]+people[right]){
                left++;
                right--;
            }else{
                right--;
            }
        }
        return answer;
    }
}