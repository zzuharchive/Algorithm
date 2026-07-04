import java.util.*;
class Solution {
    public static int INF = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] d = new int[n + 1];

        for(int i=1; i<d.length; i++){
            d[i] = INF;
        }

        d[k] = 0;

        for(int i = 0; i < n - 1; i++){
            for(int edge[] : times){
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];

                if(d[start] == INF) continue;

                d[end] = Math.min(d[start] + weight, d[end]);
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) return -1;
            answer = Math.max(answer, d[i]);
        }

        return answer;
    }
}