import java.util.*;
class Process{
    int priorities;
    int index;
    
    Process(int index, int priorities){
        this.index = index;
        this.priorities = priorities;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Process(i, priorities[i]));
        }
        
        while(true){
            Process now = queue.poll();
            int locationCount = queue.size();
            boolean flag = false;
            for(int i = 0; i<locationCount; i++){
                Process next = queue.poll();
                queue.offer(next);
                if(next.priorities>now.priorities){
                    flag = true;
                }
            }
            if(flag){
                queue.offer(now);
            }else{
                answer++;
                if(now.index == location){
                return answer;
                }   
            }
        }
    }
}