class Solution {
    public int solution(int n, int m, int[] section) {
        
        boolean[] needColor = new boolean[n];
        for(int i=0; i<section.length; i++){
            needColor[section[i] - 1] = true;
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(!needColor[i]) continue;
            for(int j = 0; j < m; j++){
                if(i + j >= n) break;
                if(needColor[i + j]) needColor[i + j] = false;
            }
            answer++;
        }
        return answer;
    }
}