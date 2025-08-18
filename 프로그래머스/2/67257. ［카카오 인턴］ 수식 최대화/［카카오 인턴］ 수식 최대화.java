import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        String[] op = new String[]{"+", "-", "*"};
        
        long max = 0;
        String now = "";
        for(int i=0; i<op.length; i++){
            for(int j=0; j<op.length; j++){
                if(i == j) continue;
                for(int k =0; k<op.length; k++){
                    if(j == k || i == k) continue;
                    now = calculate(expression, op[i]);
                    now = calculate(now, op[j]);
                    now = calculate(now, op[k]);
                    long result = Math.abs(Long.parseLong(now));
                    max = (max < result) ? result : max;
                }
                
            }
        }
        return max;
    }
    
    
    String calculate(String expression, String operation){
        
        Queue<String> expQ = new LinkedList<>();
        
        StringBuilder num = new StringBuilder();
        
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(!isOperation(c)){
                num.append(c);
            }
            else{
                if(c == '-' && (i == 0 || isOperation(expression.charAt(i-1)))){
                    num.append(c);
                }else {
                    expQ.offer(num.toString());
                    expQ.offer(String.valueOf(c));
                    num.setLength(0);   
                }
            }
        }
        expQ.offer(num.toString());
        
        long temp = Long.parseLong(expQ.poll());
        StringBuilder str = new StringBuilder();
        
        while(!expQ.isEmpty()){
            
            String currentOp = expQ.poll();
            long n = Long.parseLong(expQ.poll());
            
            if(operation.equals(currentOp)){
                switch(currentOp){
                    case "+": temp += n; break;
                    case "-": temp -= n; break;
                    case "*": temp *= n; break;
                }
            }else{
                str.append(temp).append(currentOp);
                temp = n;
            } 
        }
        str.append(temp);
        return str.toString();
    }
    
    boolean isOperation(char ch){
        return (ch == '+' || ch == '-' || ch == '*');
    }
}