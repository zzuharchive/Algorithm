import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[3];
        boolean same = true;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
            if (i > 0 && arr[i] != arr[i - 1]) same = false;
        }
        Arrays.sort(arr);
        //정삼각형
        if (same) {
            System.out.println(arr[0] * 3);
        }
        //삼각형의 조건을 만족하지 않는 경우
        else if (arr[2] >= arr[1] + arr[0]) {
            int rest = arr[0] + arr[1] - 1;
            System.out.println(arr[0] + arr[1] + rest);
        }
        //삼각형의 조건을 만족하는 경우
        else {
            System.out.println(arr[0] + arr[1] + arr[2]);
        }
    }
}
