import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int min;
        int tmpMin;
        int x=input.nextInt();
        int y= input.nextInt();
        int w= input.nextInt();
        int h= input.nextInt();

        int tmpX=w-x;
        int tmpY=h-y;

        min=(tmpX>x)?x:tmpX;
        tmpMin=(tmpY>y)?y:tmpY;

        min=(tmpMin>min)?min:tmpMin;
        System.out.println(min);

    }
}
