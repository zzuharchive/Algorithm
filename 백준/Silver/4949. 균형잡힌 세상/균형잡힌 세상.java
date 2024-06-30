import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            String s = input.nextLine();
            if (s.equals(".")) break;
            test(s);
        }
    }

    static void test(String s) {
        
        Stack<Character> bracket = new Stack<>();
        String balance = "yes";
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            //입력 종료인 경우
            if (currentChar == '.') break;

            //일반 문자인 경우
            if (currentChar >= 65 && currentChar <= 90 || currentChar >= 97 && currentChar <= 122 || s.charAt(i) == ' ')
                continue;

            //검사해야 하는 경우
            if (currentChar == '(' || currentChar == '[') {
                bracket.push(currentChar);
            } else if (currentChar == ')' || currentChar == ']') {

                //push된 괄호가 없는 경우
                if (bracket.isEmpty()) {
                    balance = "no";
                    break;
                }
                //균형잡힌 경우
                else if ((currentChar == ')' && bracket.peek() == '(') ||
                        (currentChar == ']' && bracket.peek() == '[')) {
                    bracket.pop();
                }
                //균형잡히지 않은 경우
                else {
                    balance = "no";
                    break;
                }
            }
        }
        if(!bracket.isEmpty()) balance = "no";
        System.out.println(balance);
    }
}

