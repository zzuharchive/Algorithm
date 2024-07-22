import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> set = new HashSet<>();

        int inputCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputCount; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                set.add(input.charAt(j));
            }
            System.out.println(set.size());
            set.clear();
        }
    }
}
