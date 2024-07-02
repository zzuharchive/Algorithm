import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

       Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        int count = 0;
        int deadElement = 0;
        int deleteTarget = K - 1;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }


        System.out.print("<");
        //요세푸스 순열 알고리즘
        do {
            //0. 배열 안의 모든 원소가 -1이 된 경우
            if (deadElement == N) break;

            //1. deleteTarget에 위치하는 배열 원소를 삭제한다 (-1로 변경)
            if (arr[deleteTarget] != -1) {
                if(deadElement == N-1){
                    System.out.print(arr[deleteTarget]+">");
                    break;
                }else{
                System.out.print(arr[deleteTarget]+", ");
                arr[deleteTarget] = -1;
                count = 0;
                deadElement++;}
            }

            //2. deleteTarget 이동 알고리즘
            while (count != K) {
                deleteTarget++;
                if (deleteTarget == (N)) deleteTarget = 0;
                if (arr[deleteTarget] != -1) count++;
            }
        } while (true);



    }
}
