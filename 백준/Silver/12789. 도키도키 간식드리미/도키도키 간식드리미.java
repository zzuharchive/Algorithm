
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Stack<Integer> currentLine = new Stack<>();
        Stack<Integer> waitingLine = new Stack<>();
        int correctNum = 1;
        int lastPop = 0;
        String result = "Sad";

        int N = input.nextInt();
        int[] mock = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            mock[i] = input.nextInt();
        }

        for (int i = 0; i < N; i++) {
            currentLine.push(mock[i]);
        }


        while (true) {
            //currentLine이 빈 경우
            if (currentLine.isEmpty()) {
                if (waitingLine.isEmpty()) {
                    result = "Nice";
                    break;
                }
                int chkNum = waitingLine.peek();
                if (lastPop == (chkNum - 1)) {
                    lastPop = waitingLine.pop();
                    correctNum++;
                } else {
                    break;
                }
            } else {

                //올바른 순서인 경우
                if (currentLine.peek() == correctNum) {
                    lastPop = currentLine.pop();
                    correctNum++;
                }

                //현재 줄에 있는 순번이 올바르지 않은 경우 -> 대기열에 있는 순번과 비교
                else {
                    if (!waitingLine.isEmpty() && waitingLine.peek() == correctNum) {
                        waitingLine.pop();
                        correctNum++;
                    } else waitingLine.push(currentLine.pop());
                }
            }
        }

        System.out.println(result);
    }
}
