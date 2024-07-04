import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        HashSet<String> set = new HashSet<>();

        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String tmpS = "";
        for (int i = 0; i < s.length(); i++) {
            tmpS += s.charAt(i);
            set.add(tmpS);
            for (int j = i + 1; j < s.length(); j++) {
                tmpS += s.charAt(j);
                set.add(tmpS);
            }
            tmpS = "";
        }

        System.out.println(set.size());
    }
}
