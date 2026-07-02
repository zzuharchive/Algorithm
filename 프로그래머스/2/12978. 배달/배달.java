import java.util.*;
class Node implements Comparable<Node>{
    int node;
    int weight;
    
    public Node(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
    
    public int compareTo(Node n){
        return Integer.compare(this.weight, n.weight);
    }
}
class Solution {
    public static final int MAX = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        
        List<Node>[] adj = new ArrayList[N + 1];
        int[] shortDistance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        for(int i = 1; i<= N; i++){
            adj[i] = new ArrayList<>();
            shortDistance[i] = MAX;
        }
        
        for(int[] r : road){
            int node1 = r[0]; int node2 = r[1]; int weight = r[2];
            adj[node1].add(new Node(node2, weight));
            adj[node2].add(new Node(node1, weight));
        }
        
        shortDistance[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, shortDistance[1]));
        
        while(!pq.isEmpty()){
            int cur = pq.poll().node;
            if(visited[cur]) continue;
            visited[cur] = true;
            
            for(Node node : adj[cur]){
                int num = node.node;
                if(visited[num]) continue;
                if(shortDistance[num] > shortDistance[cur] + node.weight){
                    shortDistance[num] = shortDistance[cur] + node.weight;
                    pq.offer(new Node(num, shortDistance[num]));
                }
            }
        }
        
        int answer = 0;
        
        for(int i=1; i<shortDistance.length; i++){ 
            if(shortDistance[i] <= K) answer++;
        }
        
        return answer;
    }
}