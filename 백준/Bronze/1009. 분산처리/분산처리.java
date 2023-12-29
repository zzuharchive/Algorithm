import java.util.Scanner;

public class Main {
    static int lastLetter(int a, int b, int regular){
        int save = b % regular;
        String through;
        int res=0;
        if(save==0){
            res=(int)Math.pow(a, 4);
        }else{
            res=(int)Math.pow(a, save);
        }
        through=Integer.toString(res);
        res=Integer.parseInt(through.charAt(through.length()-1)+"");

        return res;
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int tc=input.nextInt();
        for(int i=0;i<tc;i++){
            int a= input.nextInt();
            int b= input.nextInt();

            if(a>=10) a%=10;
            switch (a){
                case 0:
                    System.out.println("10");
                    break;
                case 1:
                case 5:
                case 6:
                    System.out.println(a);
                    break;
                case 2:
                case 3:
                case 7:
                case 8:
                    System.out.println(lastLetter(a, b, 4));
                    break;
                case 4:
                case 9:
                    System.out.println(lastLetter(a, b, 2));
                    break;
            }
        }
    }
}
