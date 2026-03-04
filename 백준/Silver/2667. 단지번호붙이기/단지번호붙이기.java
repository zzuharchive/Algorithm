import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = input.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int total = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    total++;
                    list.add(dfs(i, j));
                }
            }
        }

        System.out.println(total);
        list.sort(Integer::compareTo);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    static int dfs(int x, int y) {

        visited[x][y] = true;
        int count = 1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    count += dfs(nx, ny);
                }
            }
        }
        return count;
    }
}
