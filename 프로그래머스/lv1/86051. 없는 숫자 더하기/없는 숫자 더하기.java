import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        Arrays.sort(numbers);
        
        
        for(int i=0;i<=9;i++){
            for(int j=0;j<numbers.length;j++){
                if(i==numbers[j]) {
                    answer-=i;
                    break;}
            }
           
        }
        
        return answer;
    }
}