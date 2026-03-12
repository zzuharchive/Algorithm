import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] board;
    static boolean[][][] visited;
    static int k;
    static int w;
    static int h;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static class Node {

        int x;
        int y;
        int dist;
        int horseUsed;

        Node(int x, int y, int dist, int horseUsed) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.horseUsed = horseUsed;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        k = input.nextInt();
        w = input.nextInt();
        h = input.nextInt();

        board = new int[h][w];
        visited = new boolean[h][w][k + 1];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = input.nextInt();
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == h - 1 && cur.y == w - 1) {
                return cur.dist;
            }

            // 상하좌우
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                    if (board[nx][ny] == 0 && !visited[nx][ny][cur.horseUsed]) {
                        visited[nx][ny][cur.horseUsed] = true;
                        q.offer(new Node(nx, ny, cur.dist + 1, cur.horseUsed));
                    }
                }
            }

            // 나이트 움직임
            if (cur.horseUsed < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + hx[i];
                    int ny = cur.y + hy[i];

                    if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                        if (board[nx][ny] == 0 && !visited[nx][ny][cur.horseUsed + 1]) {
                            visited[nx][ny][cur.horseUsed + 1] = true;
                            q.offer(new Node(nx, ny, cur.dist + 1, cur.horseUsed + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
