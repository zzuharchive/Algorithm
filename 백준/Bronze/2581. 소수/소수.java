import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isMinimum = true;
        int sum = 0;
        int minimum = 0;
        
        int M = input.nextInt();
        int N = input.nextInt();

        for(int i = M; i <= N;i++){
            for(int j=2; j<=i;j++){
                //소수가 아님
                if(i%j==0 && j != i) {
                    break;
                }
                //소수임
                if(j==i){
                    if(isMinimum) {
                        isMinimum = false;
                        minimum = i;
                    }
                    sum+=i;
                    break;
                }
            }
        }
        if(isMinimum){
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(minimum);
    }
}
