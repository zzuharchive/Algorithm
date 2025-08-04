class Solution {
    public int solution(int[] queue1, int[] queue2) {

        long total = 0;
        long q1 = 0;
        long q2 = 0;
        int[] integrationQ = new int[queue1.length + queue2.length];
        
        for(int i=0; i<queue1.length ;i++){
            total += queue1[i];
            q1 += queue1[i];
            integrationQ[i] = queue1[i];
        }
        for(int i=0; i<queue2.length ;i++){
            total += queue2[i];
            q2 += queue2[i];
            integrationQ[queue1.length+i] = queue2[i];
        }
        
        if(total % 2 != 0) return -1;
        
        long goal = total/2;   
        int start = 0;
        int end = queue1.length;
        int count = 0;
        
        while(count <= queue1.length + queue2.length * 2){
            if (end >= integrationQ.length || start >= integrationQ.length) return -1;
            if(q1 == q2) return count;
            
            else if(q1<q2){
                q1 += integrationQ[end];
                q2 -= integrationQ[end];
                end++;
            }else if(q1>q2){
                q1 -= integrationQ[start];
                q2 += integrationQ[start];
                start++;
            }
            
            count++;
        }
        
        return -1;
    }
}