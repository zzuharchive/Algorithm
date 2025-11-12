import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        int answer = 0;
        
        while(pq.size() > 0){
           
            int min = pq.poll();
            if(min < K){
                if(pq.isEmpty()) answer = -1;
                else {
                    int mixed = min + (pq.poll() * 2);
                    answer++;
                    pq.offer(mixed);
                }
            }
        }
        return answer;
    }
}