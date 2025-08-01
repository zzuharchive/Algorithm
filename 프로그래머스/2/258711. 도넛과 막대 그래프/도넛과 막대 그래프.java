class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int edgesNum = 0;
        
        for(int i=0; i<edges.length; i++){
            for(int j=0; j<edges[i].length; j++){
                edgesNum = Math.max(edgesNum, edges[i][j]);
            }
        }
        
        int[] in = new int[edgesNum + 1];
        int[] out = new int[edgesNum + 1];
        
        for(int[] edge : edges){
            out[edge[0]]++;
            in[edge[1]]++;
        }
        
        for(int i = 1; i<= edgesNum ; i++){
            if(in[i] == 0 && out[i] >= 2) answer[0] = i;
            else if(in[i] >= 1 && out[i] == 0) answer[2]++;
            else if(in[i] >= 2 && out[i] >= 2) answer[3]++;
        }
        
        answer[1] = out[answer[0]] - answer[2] - answer[3];
        
        return answer;
    }
}