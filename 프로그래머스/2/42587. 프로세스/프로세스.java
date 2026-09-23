import java.util.*;
class Process implements Comparable<Process>{
    int loc;
    int priority;
    
    Process(int loc, int priority){
        this.loc = loc;
        this.priority = priority;
    }
    
    @Override
    public int compareTo(Process p){
        return Integer.compare(p.priority, this.priority);
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
    
        PriorityQueue<Process> pq = new PriorityQueue<>();
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++){
            q.offer(i);
            pq.offer(new Process(i, priorities[i]));
        }
        
        int answer = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            if(pq.peek().priority > priorities[cur]){
                q.offer(cur); 
            }else{
                answer++;
                pq.poll();
                if(cur == location) break;
            } 
        }
        return answer;
    }
}