import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> parentheses = new Stack<>();
        
        // 여는 괄호는 stack에 push하고, 닫는 괄호는 pop을 한다.
        for(int i=0; i<s.length();i++){
            char here = s.charAt(i);
            if(here == '('){
                parentheses.push(here);
            }else{
                try{
                    parentheses.pop();
                }catch(EmptyStackException e){
                    answer = false;
                    break;
                }
            }
        }
        
        // 괄호가 모두 닫히지 않은 경우
        if(parentheses.size()>0) answer = false;

        return answer;
    }
}