class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0; int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while(true){
            if(sum >= k){
                if(sum == k){
                    int len = end - start - 1;
                    if(minLen > len){
                        minLen = len;
                        answer[0] = start;
                        answer[1] = end - 1;
                    }
                }
                sum -= sequence[start];
                start++;
            }else{
                if(end == sequence.length) break;
                sum += sequence[end];
                end++;
            }
        }
        return answer;
    }
}