import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//두 자연수의 곱 = 최대공약수 * 최소공배수
//유클리드호제를 통해 최대공약수를 구한다.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        StringTokenizer st = new StringTokenizer(nums, " ");
        long B = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        long mul = A * B;
        long tmp;

        while (B > 0) {
            tmp = A % B;
            A = B;
            B = tmp;
        }

        System.out.println(mul / A);
    }
}
