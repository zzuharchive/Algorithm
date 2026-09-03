import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        
        deque.push(number.charAt(0));
        int remove = 0;
        for(int i = 1; i < number.length(); i++){
           
            char cur = number.charAt(i);
            
            while(remove < k && !deque.isEmpty() && deque.peek() < cur){
                deque.pop();
                remove++;
            }
            deque.push(cur);
        }
        
        while (remove < k) {
            deque.pop();
            remove++;
        }
        
        StringBuilder answer = new StringBuilder();
        
        while(!deque.isEmpty()){
            answer.append(deque.pollLast());
        }
        
        return answer.toString();
    }
}