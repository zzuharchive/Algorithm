import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, String> order = new HashMap<>();
        HashMap<String, Integer> car = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        //나가야 하는 차
        int num = 0;
        //추월한 차
        int count = 0;
        //나갔는지 체크
        boolean[] isOut = new boolean[n];

        for (int i = 0; i < n; i++) {
            String inCar = br.readLine();
            order.put(i, inCar);
            car.put(inCar, i);
        }

        for (int i = 0; i < n; i++) {
            String outCar = br.readLine();
            isOut[car.get(outCar)] = true;

            //나가야 하는 순서가 맞는 경우
            if (outCar.equals(order.get(num))) {
                while (num < n) {
                    if (!isOut[num]) break;
                    num++;
                }
            }
            //순서가 맞지 않는 경우
            else {
                count++;
            }
        }
        System.out.println(count);
    }
}
