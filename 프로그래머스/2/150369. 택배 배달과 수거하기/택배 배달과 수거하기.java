class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        long answer = 0l;
        long haveToPickup = 0l;
        long haveToDeliver = 0l;
        
        for(int i = n-1; i >= 0 ; i--){
            int index = i+1;
            haveToPickup += pickups[i];
            haveToDeliver += deliveries[i];
            
            while(haveToPickup > 0 || haveToDeliver > 0){
                
                haveToPickup -= cap;
                haveToDeliver -= cap;
                answer += index * 2l;  
            }            
        }
        return answer;
    }
}