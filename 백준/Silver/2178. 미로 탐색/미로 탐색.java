import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] array;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        array = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String setting = br.readLine();
            for(int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(setting.charAt(j) + "");
            }
        }

        bfs(0, 0);
        System.out.println(array[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {

            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && nx < array.length && ny >= 0 && ny < array[0].length) {
                    if(!visited[nx][ny] && array[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        array[nx][ny] = array[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
    }
}
