import java.util.*;
class Node implements Comparable<Node>{
    int num;
    int weight;

    public Node(int num, int weight){
        this.num = num;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return Integer.compare(this.weight, o.weight);
    }
}
class Solution {
    public static final int MAX = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Node>[] adj = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] shortest = new int[n + 1];

        for(int i=1; i <= n; i++){
            adj[i] = new ArrayList<>();
            shortest[i] = MAX;
        }

        for(int[] time : times){
            int s = time[0]; int e = time[1]; int w = time[2];
            adj[s].add(new Node(e, w));
        }

        shortest[k] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, shortest[k]));

        while(!pq.isEmpty()){
            int cur = pq.poll().num;
            if(visited[cur]) continue;
            visited[cur] = true;

            for(Node node : adj[cur]){
                int now = node.num;
                if(visited[now]) continue;
                if(shortest[cur] + node.weight < shortest[now]){
                    shortest[now] = shortest[cur] + node.weight;
                    pq.offer(new Node(now, shortest[now]));
                }
            }
        }

        int answer = 0;

        for(int i = 1; i < shortest.length; i++){
            if(shortest[i] == MAX) return -1;
            answer = Math.max(shortest[i], answer);
        }

        return answer;
    }
}