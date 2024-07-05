import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        int[] between = new int[N - 1];
        int addTree = 0;

        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(br.readLine());
            if (i > 0) {
                between[i - 1] = origin[i] - origin[i - 1];
            }
        }

        int commonDivisor = greatestCommonDivisor(between);

        for (int i = 0; i < between.length; i++) {
            addTree += between[i] / commonDivisor - 1;
        }

        System.out.println(addTree);
    }

    //최대공약수 구하기
    public static int greatestCommonDivisor(int[] between) {
        Arrays.sort(between);
        int max = 1;
        for (int i = 1; i <= between[0]; i++) {
            for (int j = 0; j < between.length; j++) {
                //약수가 아닌 경우
                if (between[j] % i != 0) break;
                if (j == between.length - 1) {
                    max = i;
                }
            }
        }
        return max;
    }
}
