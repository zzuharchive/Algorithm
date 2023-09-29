import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String number=input.next();
        int sum=0;
        for(int i=0;i< num;i++){
            sum+=Integer.parseInt(number.charAt(i)+"");
        }
        System.out.print(sum);

    }
}
