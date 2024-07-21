import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 == 0) continue;
            arrayList.add(num);
            sum += num;
        }
        if(sum == 0){
            System.out.println(-1);
            return;
        }
        Collections.sort(arrayList);
        System.out.println(sum);
        System.out.println(arrayList.get(0));
    }
}
