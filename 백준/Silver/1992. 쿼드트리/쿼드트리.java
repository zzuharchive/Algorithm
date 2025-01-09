import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] video = new int[size + 1][size + 1];

        // 배열 초기화
        for (int i = 1; i <= size; i++) {
            String oneLine = br.readLine();
            for (int j = 1; j <= size; j++) {
                video[i][j] = oneLine.charAt(j - 1) - '0';
            }
        }
        compression(video, 1, 1, size);
        System.out.println(sb);
    }

    // 압축하려는 영역을 확인.
    // 영역의 숫자가 0이나 1로 같으면 true -> 압축
    // 다르면 false
    public static boolean check(int[][] video, int x, int y, int size) {

        int num = video[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }

    // 사분면으로 나누어 압축.
    public static void compression(int[][] video, int startI, int startJ, int size) {

        // base case
        if (check(video, startI, startJ, size)) {
            sb.append(video[startI][startJ]);
            return;
        }

        sb.append("(");

        compression(video, startI, startJ, size / 2);
        compression(video, startI, startJ + size / 2, size / 2);
        compression(video, startI + size / 2, startJ, size / 2);
        compression(video, startI + size / 2, startJ + size / 2, size / 2);

        sb.append(")");
    }
}

