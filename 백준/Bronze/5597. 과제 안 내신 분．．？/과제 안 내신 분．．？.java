import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] M= new int[31];
        int not=2;
        Scanner input=new Scanner(System.in);
        for(int i=0;i<M.length;i++){
            M[i]=i;
        }
        for(int i=0;i<28;i++){
            int submit=input.nextInt();
            M[submit]=0;
        }
        for(int i=0;i<M.length;i++){
            if(not==0) break;
            if(M[i]!=0){
                not--;
                System.out.println(M[i]);
            }
        }



    }
}
