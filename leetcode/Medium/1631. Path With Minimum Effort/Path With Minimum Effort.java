import java.util.*;
class Cell implements Comparable<Cell>{
    int x;
    int y;
    int effort;

    public Cell(int x, int y, int effort){
        this.x = x;
        this.y = y;
        this.effort = effort;
    }

    @Override
    public int compareTo(Cell o){
        return Integer.compare(this.effort, o.effort);
    }
}
class Solution {
    public static final int MAX = Integer.MAX_VALUE;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length; int m = heights[0].length;
        int[][] d = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                d[i][j] = MAX;
            }
        }

        d[0][0] = 0;

        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.offer(new Cell(0, 0, 0));

        while(!pq.isEmpty()){
            Cell cur = pq.poll();
            if(visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;

            for(int i = 0; i < 4; i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                if(visited[newX][newY]) continue;

                int diff = Math.abs(heights[cur.x][cur.y] - heights[newX][newY]);
                int nextCost = Math.max(d[cur.x][cur.y], diff);

                if(nextCost < d[newX][newY]){
                    d[newX][newY] = nextCost;
                    pq.offer(new Cell(newX, newY, nextCost));
                }
            }
        }

        return d[n-1][m-1];

    }
}