import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        int timeSum = 0;
        int waitingTime = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i< n ;i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        for(int i=0; i<n;i++){
            waitingTime += time[i];
            timeSum+=waitingTime;
        }
        System.out.println(timeSum);
    }
}
