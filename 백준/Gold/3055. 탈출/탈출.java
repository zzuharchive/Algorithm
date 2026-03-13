import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int r;
    static int c;
    static char[][] board;
    static boolean[][] visited;
    static Block start;
    static Block target;
    static Queue<Block> water = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Block {

        int x, y;

        Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node extends Block {

        int dist;

        Node(int x, int y, int dist) {
            super(x, y);
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        c = input.nextInt();

        board = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = input.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'D') {
                    target = new Block(i, j);
                } else if (board[i][j] == 'S') {
                    start = new Block(i, j);
                } else if (board[i][j] == '*') {
                    water.offer(new Block(i, j));
                }
            }
        }

        int result = bfs();
        System.out.println((result == -1) ? "KAKTUS" : result);
    }

    // BFS
    private static int bfs() {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(start.x, start.y, 0));
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {

            // 물 확장
            int size = water.size();
            for (int i = 0; i < size; i++) {
                Block w = water.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = w.x + dx[j];
                    int ny = w.y + dy[j];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] == '.') {
                        water.offer(new Block(nx, ny));
                        board[nx][ny] = '*';
                    }
                }
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node cur = q.poll();
                if (cur.x == target.x && cur.y == target.y) {
                    return cur.dist;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && (board[nx][ny] == '.'
                        || board[nx][ny] == 'D')) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new Node(nx, ny, cur.dist + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}