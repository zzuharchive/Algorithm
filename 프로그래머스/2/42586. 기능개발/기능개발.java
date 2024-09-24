import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length;i++){
            int rest = 100 - progresses[i];
            int need = rest/speeds[i];
            need = (rest%speeds[i]!=0) ?  need + 1 : need;
            
            q.offer(need);
        }
        
        while(!q.isEmpty()){
            int days = 1;
            int here = q.poll();
            while(q.size()>0 && q.peek() <= here) {
                q.poll();
                days++;
            }
            answerList.add(days);
        }
        
        answer = answerList.stream()
            .mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}