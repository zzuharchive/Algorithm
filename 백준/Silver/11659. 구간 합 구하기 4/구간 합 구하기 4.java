import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer setting = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(setting.nextToken());
        int m	= Integer.parseInt(setting.nextToken());

        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        arr[0] = 0;
        sum[0] = 0;

        StringTokenizer inputArrayVal = new StringTokenizer(br.readLine(), " ");

        for(int i=1; i<arr.length; i++){
            arr[i] = Integer.parseInt(inputArrayVal.nextToken());
            sum[1] = arr[1];

            if(i>1){
                sum[i] = sum[i-1] + arr[i];
            }
        }

        for(int k=0; k<m; k++){
            StringTokenizer part = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(part.nextToken());
            int j = Integer.parseInt(part.nextToken());

            sb.append(sum[j] - sum[i-1]+"\n");
        }

        System.out.println(sb);
    }
}

