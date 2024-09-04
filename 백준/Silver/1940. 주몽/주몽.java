import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int start = 0;
        int end = n - 1;
        int count = 0;
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while(start != end){

            if(arr[start]+arr[end] == m){
                count++;
                start++;
            }else if(arr[start]+arr[end] > m){
                end--;
            }else{
                start++;
            }
        }
        System.out.println(count);
    }
}
