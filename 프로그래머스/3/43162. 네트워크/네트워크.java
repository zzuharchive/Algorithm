class Solution {
    static boolean[] visited;
  
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        visited = new boolean[n];

        for(int i=0; i<visited.length;i++){
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int n, int[][] computers){
       visited[n] = true;
        for(int i=0; i<computers.length; i++){
            if(!visited[i] && computers[n][i] == 1){
                dfs(i, computers);
            }
        }
    }
}