import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static char[] source;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] setting = br.readLine().split(" ");

        N = Integer.parseInt(setting[0]);
        M = Integer.parseInt(setting[1]);

        source = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(source);

        makeSecretKey("", 0);
        System.out.println(sb);
    }

    static void makeSecretKey(String secretKey, int start) {

        if (secretKey.length() == N) {
            if (isValid(secretKey)) {
                sb.append(secretKey).append("\n");
            }
            return;
        }

        for (int i = start; i < source.length; i++) {
            char current = source[i];
            makeSecretKey(secretKey + current, i + 1);
        }
    }

    static boolean isValid(String secretKey) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < secretKey.length(); i++) {

            char now = secretKey.charAt(i);
            if (now == 'a' || now == 'e' || now == 'o'
                || now == 'u' || now == 'i') {
                vowels++;
            } else {
                consonants++;
            }
        }
        if (vowels >= 1 && consonants >= 2) {
            return true;
        }
        return false;
    }
}
