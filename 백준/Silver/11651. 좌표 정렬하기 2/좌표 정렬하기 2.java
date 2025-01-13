import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++) {
            String[] arrSetting = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(arrSetting[0]);
            arr[i][1] = Integer.parseInt(arrSetting[1]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
        });

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
