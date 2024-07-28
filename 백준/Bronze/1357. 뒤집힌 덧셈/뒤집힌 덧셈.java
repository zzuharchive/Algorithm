import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

        int sum = rev(st.nextToken()) + rev(st.nextToken());
        System.out.println(rev(Integer.toString(sum)));
    }

    static int rev(String num) {
        String temp = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            temp += num.charAt(i);
        }

        return Integer.parseInt(temp);
    }
}
