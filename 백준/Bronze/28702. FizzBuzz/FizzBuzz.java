import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[3];

        String answer = "FizzBuzz";
        int now = 0;
        int index = 0;

        for (int i = 0; i < 3; i++) {
            str[i] = br.readLine();
            if (!(str[i].equals("Fizz") || str[i].equals("Buzz") || str[i].equals("FizzBuzz"))) {
                index = i + 1;
                now = Integer.parseInt(str[i]);
            }
        }
        now = now + (4 - index);

        if (now % 3 == 0 && now % 5 == 0) {
            answer = "FizzBuzz";
        } else if (now % 3 == 0 && now % 5 != 0) {
            answer = "Fizz";
        } else if (now % 3 != 0 && now % 5 == 0) {
            answer = "Buzz";
        } else if (now % 3 != 0 && now % 5 != 0) {
            answer = String.valueOf(now);
        }

        System.out.println(answer);
    }

}
