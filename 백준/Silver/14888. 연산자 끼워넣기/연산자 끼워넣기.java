import java.util.Scanner;

public class Main {

    static int max;
    static int min;
    static int n;
    static int[] num;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = input.nextInt();
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        int[] operation = new int[4];
        for (int i = 0; i < 4; i++) {
            operation[i] = input.nextInt();
        }

        dfs(1, num[0], operation[0], operation[1], operation[2], operation[3]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int currentResult, int plus, int minus, int mul, int div) {
        if (depth == n) {
            if (currentResult > max) {
                max = currentResult;
            }
            if (currentResult < min) {
                min = currentResult;
            }
            return;
        }

        if (plus > 0) {
            dfs(depth + 1, currentResult + num[depth], plus - 1, minus, mul, div);
        }
        if (minus > 0) {
            dfs(depth + 1, currentResult - num[depth], plus, minus - 1, mul, div);
        }
        if (mul > 0) {
            dfs(depth + 1, currentResult * num[depth], plus, minus, mul - 1, div);
        }
        if (div > 0) {
            dfs(depth + 1, div(currentResult, num[depth]), plus, minus, mul, div - 1);
        }
    }

    static int div(int num1, int num2) {
        int div = Math.abs(num1) / num2;
        return (num1 < 0) ? -div : div;
    }
}
