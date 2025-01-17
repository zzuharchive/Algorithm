import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count = 0;
    static int r;
    static int c;
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] setting = br.readLine().split(" ");

        int n = Integer.parseInt(setting[0]);
        n = (int) Math.pow(2, n);

        r = Integer.parseInt(setting[1]);
        c = Integer.parseInt(setting[2]);

        sequence(0, 0, n);
        System.out.println(count);
    }

    static void sequence(int x, int y, int size) {

        if (isEnd) {
            return;
        }

        // 해당 영역에 목표 좌표가 없는 경우
        if (!hasPoint(x, y, size)) {
            count += size * size;
            return;
        }
        if (size == 1) {
            if (x == r && y == c) {
                isEnd = true;
            } else {
                count++;
            }
            return;
        }

        sequence(x, y, size / 2);
        sequence(x, y + size / 2, size / 2);
        sequence(x + size / 2, y, size / 2);
        sequence(x + size / 2, y + size / 2, size / 2);

    }

    static boolean hasPoint(int x, int y, int size) {
        return r >= x && r < x + size && c >= y && c < y + size;
    }
}
