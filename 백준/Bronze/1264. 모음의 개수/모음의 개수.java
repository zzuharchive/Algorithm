import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        do {
            count = 0;
            String sentence = br.readLine();
            sentence = sentence.toLowerCase();

            if (sentence.equals("#")) break;

            for (int i = 0; i < sentence.length(); i++) {

                char character = sentence.charAt(i);
                if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                    count += 1;
                }
            }

            System.out.println(count);
        } while (true);
    }
}
