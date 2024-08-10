import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(n>0){
            StringTokenizer input = new StringTokenizer(br.readLine()," ");
            String command = input.nextToken();
            if(command.equals("push")){
                int value = Integer.parseInt(input.nextToken());
                stack.add(value);
            }
            switch (command){
                case "pop":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty()?1:0);
                    break;
                case "top":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.peek());
                    break;
            }
            n--;
        }
    }
}
