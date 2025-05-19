import java.util.Scanner;

class Elevator {

    int up;
    int down;
    int num;
}

public class Main {

    static int[] lowFloor;
    static int n;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int m = input.nextInt();

        Elevator[] e = new Elevator[m];
        lowFloor = new int[m];

        for (int i = 0; i < m; i++) {
            e[i] = new Elevator();
            e[i].up = input.nextInt();
            e[i].down = input.nextInt();
            e[i].num = i;
        }

        for (int i = 0; i < m; i++) {
            getLowFloor(e[i], 0, n);
        }

        int min = lowFloor[0];

        for (int i = 0; i < m; i++) {
            min = Math.min(min, lowFloor[i]);
        }
        System.out.println(min);
    }

    static void getLowFloor(Elevator e, int start, int end) {
        if (end < 0 || start > end) {
            return;
        }
        int median = (start + end) / 2;
        int value = e.up * median - e.down * (n - median);

        if (value > 0) {
            if (e.up * (median - 1) - e.down * (n - (median - 1)) < 0) {
                lowFloor[e.num] = value;
            } else {
                getLowFloor(e, 0, median - 1);
            }
        } else if (value < 0) {
            getLowFloor(e, median + 1, end);
        } else {
            lowFloor[e.num] = e.up * (median + 1) - e.down * (n - (median + 1));
        }
    }
}

