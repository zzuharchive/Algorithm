import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());
            if (N > 1) {
                for (long j = 2; j <= (long) Math.sqrt(N); j++) {
                    //약수가 존재
                    if (N % j == 0) {
                        j = 1;
                        N += 1;
                    }
                }
            } else N = 2;
            sb.append(N).append("\n");
        }
        System.out.println(sb);
    }
}
