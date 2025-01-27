import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int day = input.nextInt();
        int totalCount = input.nextInt();

        int[][] dayTable = new int[3][day + 1];

        // 첫째 날, 할머니가 주신 떡의 개수
        int firstRiceCakeCount = 1;

        // 첫째 날
        dayTable[1][1] = 1;
        dayTable[2][1] = 0;
        // 둘째 날
        dayTable[1][2] = 0;
        dayTable[2][2] = 1;

        for (int i = 3; i <= day; i++) {
            dayTable[1][i] = dayTable[1][i - 1] + dayTable[1][i - 2];
            dayTable[2][i] = dayTable[2][i - 1] + dayTable[2][i - 2];
        }

        while (true) {
            int finalFirstCount = dayTable[1][day] * firstRiceCakeCount;
            int remainder = totalCount - finalFirstCount;

            if (remainder % dayTable[2][day] == 0) {
                int secondCount = remainder / dayTable[2][day];
                System.out.println(firstRiceCakeCount + "\n" + secondCount);
                break;
            }
            firstRiceCakeCount++;
        }
    }
}