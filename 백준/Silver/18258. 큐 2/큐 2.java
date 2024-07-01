import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ArraryQueue {

    static final int DEFAULT_SIZE = 2000000;
    static int size = 0;
    static int frontIndex = 0;
    static int backIndex = 0;
    int[] queue = new int[DEFAULT_SIZE];

    void push(int X) {
        queue[backIndex++] = X;
        size++;
    }

    int front() {
        if (empty() == 1) return -1;
        return queue[frontIndex];
    }

    int back() {
        if (empty() == 1) return -1;
        return queue[backIndex - 1];
    }

    int pop() {
        if (empty() == 1) return -1;
        size--;
        return queue[frontIndex++];
    }

    int empty() {
        if (size == 0) return 1;
        else return 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        ArraryQueue q = new ArraryQueue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            StringTokenizer st = new StringTokenizer(command);
            command = (st.countTokens() > 1) ? st.nextToken() : command;

            switch (command) {
                case "push":
                    q.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(q.pop()).append('\n');
                    break;
                case "size":
                    sb.append(q.size).append('\n');
                    break;
                case "empty":
                    sb.append(q.empty()).append('\n');
                    break;
                case "front":
                    sb.append(q.front()).append('\n');
                    break;
                case "back":
                    sb.append(q.back()).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());

    }

}
