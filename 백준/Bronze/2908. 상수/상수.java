import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int a= input.nextInt();
        int b= input.nextInt();
        int answer=0;
        String aStr = a + "";
        String bStr = b + "";
        String revStrA="";
        String revStrB="";

        for(int i=aStr.length()-1;i>=0;i--){
            revStrA+=aStr.charAt(i);
            revStrB+=bStr.charAt(i);
        }
        a=Integer.parseInt(revStrA);
        b=Integer.parseInt(revStrB);
        System.out.println(a>b?a:b);
    }
}
