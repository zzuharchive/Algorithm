import java.util.Scanner;

public class Main {

    static boolean visit[][];
    static char[][] board;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        board = new char[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String line = input.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int powerOfW = 0;
        int powerOfB = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    char team = board[i][j];
                    int power = dfs(i, j, team);
                    power *= power;

                    if (team == 'W') {
                        powerOfW += power;
                    } else {
                        powerOfB += power;
                    }
                }
            }
        }
        System.out.println(powerOfW + " " + powerOfB);
    }

    private static int dfs(int x, int y, char cur) {

        visit[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length) {
                if (!visit[nx][ny] && board[nx][ny] == cur) {
                    count += dfs(nx, ny, board[nx][ny]);
                }
            }
        }

        return count;
    }
}
