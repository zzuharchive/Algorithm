import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        do {
            String word = br.readLine();
            if (word.equals("0")) return;
            String result = "yes";
            for (int i = 0; i < word.length(); i++) {
                int num = Integer.parseInt(word.charAt(i) + "");
                queue.add(num);
                stack.add(num);
            }

            for (int i = 0; i < word.length(); i++) {
                if (queue.poll() != stack.pop()) result = "no";

            }
            System.out.println(result);
        } while (true);
    }
}
