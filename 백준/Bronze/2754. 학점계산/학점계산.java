import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String score = br.readLine();
        double scoreVal = 0.0;

        if (score.equals("F")) {
            System.out.print("0.0");
            return;
        }

        switch (score.charAt(0)) {
            case 'A':
                scoreVal = 4.0;
                break;
            case 'B':
                scoreVal = 3.0;
                break;
            case 'C':
                scoreVal = 2.0;
                break;
            case 'D':
                scoreVal = 1.0;
                break;
        }
        
        switch (score.charAt(1)) {
            case '+':
                scoreVal += 0.3;
                break;
            case '-':
                scoreVal -= 0.3;
                break;
            case '0':
                break;
        }

        System.out.println(scoreVal);
    }
}
