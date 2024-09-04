import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        for(int i=0; i<arr.length;i++){
            arr[i] = i;
        }

        while(end != n+1){

            if(sum<n){
                end++;
                sum += end;
            }else if(sum>n){
                sum -= start;
                start++;
            }else{
                count++;
                end++;
                sum+=end;
            }
        }
        System.out.println(count);
    }
}
