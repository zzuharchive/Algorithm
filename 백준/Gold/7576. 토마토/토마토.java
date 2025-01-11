import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Tomato> queue = new LinkedList<>();
    static int[][] tomatoBox;
    static int answer = 0;

    static class Tomato {

        int x;
        int y;
        int day;
        boolean isDelicious = false;

        Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 토마토 박스 초기화
        String[] setting = br.readLine().split(" ");
        int sizeX = Integer.parseInt(setting[1]);
        int sizeY = Integer.parseInt(setting[0]);

        tomatoBox = new int[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            String[] tomatoes = br.readLine().split(" ");
            for (int j = 0; j < sizeY; j++) {
                tomatoBox[i][j] = Integer.parseInt(tomatoes[j]);
                if (tomatoBox[i][j] == 1) {
                    queue.offer(new Tomato(i, j, 0));
                }

            }
        }

        beDelicious();
        System.out.println(check() ? answer : -1);
    }

    // 숙성
    static void beDelicious() {

        while (!queue.isEmpty()) {

            Tomato current = queue.poll();

            int x = current.x;
            int y = current.y;
            int day = current.day;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newX && newX < tomatoBox.length && 0 <= newY
                    && newY < tomatoBox[0].length) {

                    if (tomatoBox[newX][newY] == 0) {
                        tomatoBox[newX][newY] = 1;
                        queue.add(new Tomato(newX, newY, day + 1));
                        answer = day + 1;
                    }
                }
            }

        }
    }

    // 다 익었는지 확인
    static boolean check() {
        for (int i = 0; i < tomatoBox.length; i++) {
            for (int j = 0; j < tomatoBox[0].length; j++) {
                if (tomatoBox[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
