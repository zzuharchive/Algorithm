import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                int sbNum = 0;
                sbNum = (heap.size() > 0) ? heap.poll() : 0;
                sb.append(sbNum + "\n");

            } else {
                heap.add(num);
            }
        }
        System.out.println(sb);
    }
}
