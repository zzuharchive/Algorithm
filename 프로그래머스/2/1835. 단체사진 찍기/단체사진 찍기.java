import java.util.*;
class Cond{
    char c1;
    char c2;
    char op;
    int value;
}

class Solution {
    boolean[] used;
    int answer;
    char[] ch = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    int[] position = new int[91];
    Cond[] conditions;
    public int solution(int n, String[] data) {
        
        answer = 0;
        used = new boolean[8];
        Arrays.fill(position, -1);
        conditions = new Cond[data.length];
        for(int i=0; i<data.length; i++){
            Cond c = new Cond();
          
            c.c1 = data[i].charAt(0);
            c.c2 = data[i].charAt(2);
            c.op = data[i].charAt(3);
            c.value = data[i].charAt(4) - '0';
            conditions[i] = c;
        }
        
        backTracking(0);
        return answer;
    }
    
    void backTracking(int depth){
        if(depth == 8){
            answer++;
            return;
        }
        
        for(int i=0; i<ch.length; i++){
            if(used[i]) continue;
            
            used[i] = true;
            position[ch[i]] = depth;
            
            if(isValid()){
                backTracking(depth + 1);
            }
            
            position[ch[i]] = -1;
            used[i] = false;
        }        
    }
    
    boolean isValid(){
        
        for(Cond cond : conditions){
            
            int c1Idx = position[cond.c1];
            int c2Idx = position[cond.c2];
            
            if(c1Idx == -1 || c2Idx == -1) continue;
            
            int distance = Math.abs(c1Idx - c2Idx) - 1;  
            
            if(cond.op == '=' && distance != cond.value) return false;
            if(cond.op == '<' && distance >= cond.value) return false;
            if(cond.op == '>' && distance <= cond.value) return false;
        }
        return true;
    }
}