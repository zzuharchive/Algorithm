import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = "";
        int sum = 0;
        boolean isMinus = false;


        String expression = "+" + br.readLine();

        for (int i = 0; i < expression.length(); ) {
            
            num = "";
            
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                
                //숫자 세기
                int j = i + 1;
                while (!(expression.charAt(j) == '+' || expression.charAt(j) == '-')) {
                    num += expression.charAt(j);
                    j += 1;
                    if (j >= expression.length()) break;
                }
                
                //해당 숫자의 부호가 마이너스인 경우 -> 이후 나오는 숫자를 모두 minus로 계산한다.
                if (expression.charAt(i) == '-') isMinus = true;

                if (isMinus) {
                    sum -= Integer.parseInt(num);
                } else sum += Integer.parseInt(num);

                i = j;
            }
        }

        System.out.println(sum);
    }
}
