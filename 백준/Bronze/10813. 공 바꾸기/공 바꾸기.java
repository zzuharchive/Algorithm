import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, M;
        int tmp;
        Scanner input = new Scanner(System.in);
        N= input.nextInt();
        M= input.nextInt();
        int[] arrayN=new int[N];

        for(int i=0;i< arrayN.length;i++){
            arrayN[i]=i+1;
        }
        for(int i=0;i<M;i++){
            int swap1= input.nextInt();
            int swap2= input.nextInt();

            tmp=arrayN[swap1-1];
            arrayN[swap1-1]=arrayN[swap2-1];
            arrayN[swap2-1]=tmp;
        }
        for(int i=0;i< arrayN.length;i++){
            System.out.print(arrayN[i]+" ");
        }
    }
}
