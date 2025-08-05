class Solution {
    int[] best = {-1};
    int maxDiff = 0;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        int[] ryan = new int[info.length];
        
        dfs(0, n, ryan, info);
       
        return best;
    }
    
    void dfs(int index, int arrow, int[] ryan, int[] info){
        // 해당 인덱스가 info 끝까지 왔을 때, 점수를 계산한다.
        if(arrow == 0 || index == info.length){
            
            int apeachScore = 0;
            int ryanScore = 0;
            
            if(arrow > 0) ryan[10] += arrow;
            
            for(int i=0; i < ryan.length; i++){
                if(ryan[i] == 0 && info[i] == 0) continue;
                if(ryan[i] > info[i]) ryanScore += (10 - i);
                else apeachScore += (10 - i);
            }
            
            if(ryanScore > apeachScore){
                int diff = ryanScore - apeachScore;
                if(diff > maxDiff){
                    maxDiff = diff;
                    best = ryan.clone();
                }else if(diff == maxDiff){
                    for(int i = ryan.length -1; i >= 0; i--){
                        if(ryan[i] > best[i]) {
                            best = ryan.clone();
                            break;
                        }
                        else if(ryan[i] < best[i])  break;
                    }
                }    
            }
            
            if(arrow > 0) ryan[10] -= arrow;
            return;
        }
        
        // 해당 점수에 화살을 맞히는 경우
        int needArrow = info[index] + 1;
        if(needArrow <= arrow){
            ryan[index] = needArrow;
            dfs(index+1, arrow - needArrow, ryan, info);
            ryan[index] = 0;                
        }
        
        // 화살을 맞히지 않는 경우
        dfs(index+1, arrow, ryan, info);
    }
}