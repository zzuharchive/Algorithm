import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] remainder=new int[10];
        int result=0;
        // 나머지를 저장할 배열 초기화 하기
        for(int i=0;i<remainder.length;i++){
            remainder[i]=-1;
        }

        //숫자 입력하기
        for(int i=0;i< remainder.length;i++){
            int n= input.nextInt();
            if(i==0) remainder[i]=n%42;
           // System.out.println("저장될 값: "+n%42);
            // j는 remainder 배열 인덱스를 control하는 변수
            for(int j=0;j<=i;j++){
                //if 입력한 숫자%42가 이미 배열에 저장된 수라면 반복문을 빠져나감.
                if(remainder[j]==n % 42)
                    break;
                //배열에 없는 수라면, 배열에 새로 저장한다.
                else if( remainder[j]==-1 && remainder[j]!=(n%42) ) {
                    remainder[j]=n % 42;
                    break;
                }
            }
        }
        for(int i=0;i<remainder.length;i++){
            if(remainder[i]!=-1) {
                result++;
            }
        }
        System.out.print(result);

    }
}
