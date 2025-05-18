import static java.lang.Math.max;
import java.util.Scanner;

class Counsel {

    int time;
    int price;
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] dpTable = new int[n];
        Counsel[] counsels = new Counsel[n];

        for (int i = 0; i < n; i++) {
            counsels[i] = new Counsel();
            counsels[i].time = input.nextInt();
            counsels[i].price = input.nextInt();
        }

        if(n == 1){
            int result = (counsels[0].time > 1) ? 0 : counsels[0].price;
            System.out.println(result);
            return;
        }

        if(counsels[0].time > n){
            dpTable[0] = 0;
        }else{
            dpTable[0] = counsels[0].price;
        }

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (j + counsels[j].time - 1 < i) {
                    max = max(max, dpTable[j]);
                }
            }
            if (i + counsels[i].time - 1 >= n) {
                dpTable[i] = max;
                continue;
            }
            dpTable[i] = max + counsels[i].price;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result < dpTable[i] ? dpTable[i] : result;
        }

        System.out.println(result);
    }
}