import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new ArrayList[numCourses];
        int[] d = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            list[i] = new ArrayList<>();
        }

        for(int[] arr : prerequisites){
            int a = arr[0]; int b = arr[1];
            list[b].add(a);
            d[a]++;
        }

        boolean[] visited = new boolean[numCourses];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<visited.length; i++){
            if(d[i] == 0) q.offer(i);
        }

        List<Integer> answer = new ArrayList<>();

        while(!q.isEmpty()){
            int cur = q.poll();
            answer.add(cur);
            visited[cur] = true;

            for(int i=0; i<list[cur].size(); i++){
                int now = list[cur].get(i);
                d[now]--;
                if(d[now] == 0 && !visited[now]) q.offer(now);
            }
        }

        return (answer.size() == numCourses);
    }
}