import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] list = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        distance[1] = 0;
        
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 2; i < distance.length ;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        
        for(int[] e : edge){
            int n1 = e[0];
            int n2 = e[1];
            
            list[n1].add(n2);
            list[n2].add(n1);
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int node : list[cur]){
                if(!visited[node]){
                    visited[node] = true;
                    distance[node] = distance[cur] + 1;
                    q.offer(node);
                }
            }
        }
        
        int answer = 0;
        int max = distance[1];
        for(int i=2; i<distance.length; i++){
            if(max < distance[i]){
                answer = 1;
                max = distance[i];
            }else if(max == distance[i]) answer++;
        }
        return answer;
    }
}