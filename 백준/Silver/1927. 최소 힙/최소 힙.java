import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> h = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(h.isEmpty()) sb.append("0\n");
                else sb.append(h.poll()+"\n");
            }
            else{
                h.add(x);
            }
        }
        System.out.print(sb);


    }
}
