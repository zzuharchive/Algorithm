import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dpTable;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dpTable = new int[n + 1];
        for (int i = 2; i < dpTable.length; i++) {
            dpTable[i] = -1;
        }
        
        dpTable[0] = 0;
        dpTable[1] = 1;

        for (int i = 2; i < dpTable.length; i++) {
            dpTable[i] = dpTable[i - 2] + dpTable[i - 1];
        }
        System.out.println(dpTable[n]);
    }
}
