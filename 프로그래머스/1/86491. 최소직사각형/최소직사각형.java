class Solution {
    public int solution(int[][] sizes) {
        
        int firstLen = 0; int secondLen = 0;
        
        for(int i=0; i<sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            firstLen = Math.max(max, firstLen);
            secondLen = Math.max(min, secondLen);
        }
        
        return firstLen * secondLen;
    }
}