import java.util.*;
class Solution {
    StringBuilder answer = new StringBuilder();
    public String solution(String p) {
       
        return solveProblem(p);
    }
    
    boolean isCorrect(String str){
        
        Deque<Character> stack = new ArrayDeque<>();
    
        for(int i=0; i<str.length(); i++){
           if(str.charAt(i) == '('){
               stack.push('(');
           }else if(str.charAt(i) == ')'){
               if(stack.isEmpty()) return false;
               stack.pop();
           }
        }
        
        return (stack.isEmpty()) ? true : false;
    }
    
    String getBalanceStr(String u){
        int open = 0;
        int close = 0;
        StringBuilder str = new StringBuilder();
        
        for(int i=0; i<u.length(); i++){
            
            if(u.charAt(i) == '('){
                open++;
            }else if(u.charAt(i) == ')'){
                close++;
            }
            
            str.append(u.charAt(i)+"");
            if(open == close) break;
        }
        return str.toString();
    }
    
    String solveProblem(String s){
        
        if(s.isEmpty()) return "";
       
        String u = getBalanceStr(s);
        String v = s.substring(u.length());
        
        if(isCorrect(u)){
           return u + solveProblem(v); 
        } 
        else{
            return "(" + solveProblem(v) + ")" + invert(u.substring(1, u.length()-1));
        }
    }
    
    String invert(String str){
        StringBuilder val = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char invertVal = (str.charAt(i) == ')') ? '(' : ')';
            val.append(""+invertVal);
        }
        return val.toString();
    }
}