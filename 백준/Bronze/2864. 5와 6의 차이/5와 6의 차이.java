import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String num1 = st.nextToken();
        String num2 = st.nextToken();

        String minNum1 = num1.replace('6', '5');
        String minNum2 = num2.replace('6', '5');
        int min = Integer.parseInt(minNum1) + Integer.parseInt(minNum2);

        String maxNum1 = num1.replace('5', '6');
        String maxNum2 = num2.replace('5', '6');
        int max = Integer.parseInt(maxNum1) + Integer.parseInt(maxNum2);

        System.out.println(min + " " + max);

    }
}
