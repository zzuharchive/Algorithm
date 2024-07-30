import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] studentLine = new int[n];
        
        for (int i = 0; i < studentLine.length; i++) {
            studentLine[i] = i + 1;
        }
        
        for (int i = 0; i < n; i++) {
            int num = input.nextInt();
            if (num == 0) continue;
            int temp = studentLine[i];
            for (int j = i - 1; j >= i - num; j--) {
                studentLine[j + 1] = studentLine[j];
            }
            studentLine[i - num] = temp;
        }
        
        for (int i = 0; i < studentLine.length; i++) {
            System.out.println(studentLine[i]);
        }
    }
}
