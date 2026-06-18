import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<Integer>[] list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(computers[i][j]==1) list[i].add(j);
            }
        }

        visited = new boolean[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
                
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            q.add(i);
            visited[i] = true;
            answer++;
            
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int node : list[cur]){
                    if(!visited[node]) {
                        q.add(node);
                        visited[node] = true;
                    }
                }
            }
        }
        return answer;
    }
}