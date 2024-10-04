import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int index = 1;

        while (true) {
            int addN = index;
            String s = Integer.toString(addN);
            for (int j = 0; j < s.length(); j++) {
                addN += Integer.parseInt(s.charAt(j) + "");
            }
            set.add(addN);
            if (index >= 10000) break;
            index++;
        }

        for (int i = 1; i <= 10000; i++) {
            if (set.contains(i)) continue;
            sb.append(i + "\n");
        }

        System.out.println(sb);

    }
}
