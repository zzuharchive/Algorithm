import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        int n = input.nextInt();
        int m = input.nextInt();
        int answer = 0;

        int nowX = input.nextInt();
        int nowY = input.nextInt();
        int direction = input.nextInt();

        int[][] tiles = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tiles[i][j] = input.nextInt();
            }
        }

        while (true) {
            if (tiles[nowX][nowY] == 0) {
                tiles[nowX][nowY] = 2;
                answer++;
            }
            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + x[i];
                int nextY = nowY + y[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    // 빈 칸이 있는 경우
                    if (tiles[nextX][nextY] == 0) {
                        direction = (direction + 3) % 4;
                        if (tiles[nowX + x[direction]][nowY + y[direction]] == 0) {
                            nowX += x[direction];
                            nowY += y[direction];
                            moved = true;
                            break;
                        } else {
                            moved = true;
                            break;
                        }
                    }
                }
            }
            if (!moved) {
                int backX = nowX - x[direction];
                int backY = nowY - y[direction];
                if (backX >= 0 && backX < n && backY >= 0 && backY < m
                ) {
                    if (tiles[backX][backY] != 1) {
                        nowX = backX;
                        nowY = backY;
                    } else {
                        System.out.println(answer);
                        return;
                    }

                }
            }
        }

    }
}

