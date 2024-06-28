import java.util.Scanner;

/*
해당 알고리즘은 규칙이 있다.
알고리즘을 실행할 때마다 한 변에 존재하는 점의 개수가
    점의 개수 = 점의 개수 + 점의 개수 - 1
의 규칙을 이룬다는 것이다.

따라서 해당 규칙과 정사각형인 특징을 활용하면 문제를 풀 수 있다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        int point = 2;

        for(int i = 0; i<N;i++){
             point += point-1;
        }

        System.out.println(point*point);

    }
}
