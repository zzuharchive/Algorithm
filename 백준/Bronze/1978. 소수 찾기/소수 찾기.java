
/*
1. N을 입력한다.
2. for -> 수를 입력받는다.
    2-1. 소수인 경우 count++
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        int N = input.nextInt();

        for(int i=0; i<N;i++){
            int num = input.nextInt();
            if (num==1) continue;
            count++;
            for(int j=2; j<num;j++){
                if(num%j==0) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
