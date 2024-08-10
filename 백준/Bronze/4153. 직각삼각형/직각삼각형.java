import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[3];
        while(true){
            
            String result = "wrong";
            String input = br.readLine();
            
            StringTokenizer st = new StringTokenizer(input," ");
            
            if(input.equals("0 0 0")) break;

            num[0] = Integer.parseInt(st.nextToken());
            num[1] = Integer.parseInt(st.nextToken());
            num[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(num);

            if(num[2]*num[2] == (num[0]*num[0]+num[1]*num[1])) result = "right";

            System.out.println(result);
        }
    }
}
