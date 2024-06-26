import java.util.Scanner;

/*
1. 10진수 N과 진법을 가리키는 B를 입력받는다.
2. N%B의 값을 연산한다. 이 때 결과 값이 10이상인 경우 알파벳으로 표현하도록 한다.
3. 결과 값을 문자열로 저장하고, 거꾸로 출력한다.

 */
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int B = input.nextInt();
        boolean flag = false;
        String result = "";

        while(true){

            int res = N%B;
            N /= B;

            if(res>=10) result += (char)(res+55);
            else result += res;

            if(N<B){
                if(N>=10) result += (char)(N+55);
                else result +=N;
                break;
            }
        }

        for(int i=result.length()-1; i>=0;i--){
            if(result.charAt(i)=='0' && !flag) {
                continue;
            }
            if(result.charAt(i)!='0') flag = true;
            System.out.print(result.charAt(i));
        }
    }
}
