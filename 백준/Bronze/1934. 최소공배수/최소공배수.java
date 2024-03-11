import java.util.Scanner;

public class Main {
    static void meThod(int a, int b){
        int i=2;
        int value=1;
        if(a==1||b==1){
            System.out.println(a*b);
        }
        else{
            while(true){
                if(a<i||b<i){
                    System.out.println(a*b*value);
                    return;
                }
                else if(a%i==0&&b%i==0){
                    a/=i;
                    b/=i;
                    value*=i;
                }
                else{
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int T= input.nextInt();
        int [][] num= new int[T][2];
        for(int i=0;i< T;i++){
            for (int j=0;j<2;j++){
                num[i][j]= input.nextInt();
            }
        }
        for(int i=0;i< T;i++){
            meThod(num[i][0],num[i][1]);
        }


    }
}
