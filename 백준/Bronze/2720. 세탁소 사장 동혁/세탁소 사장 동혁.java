import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        final int QUARTER = 25;
        final int DIME = 10;
        final int NICKEL = 5;
        final int PENNY = 1;

        int T = input.nextInt();

        for(int i=0; i<T;i++){
            int money = input.nextInt();
            int q = money / QUARTER;
            money %= QUARTER;

            int d = money / DIME;
            money %= DIME;

            int n = money / NICKEL;
            money %= NICKEL;

            int p = money / PENNY;
            money %= PENNY;

            System.out.println(q+" "+d+" "+n+" "+p);
        }
    }
}
