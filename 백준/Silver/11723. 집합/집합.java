import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

       long commandLine = Long.parseLong(br.readLine());
        while (commandLine > 0) {
            int num = 0;
            StringTokenizer command = new StringTokenizer(br.readLine(), " ");
            String run = command.nextToken();
            if (!run.equals("all") && !run.equals("empty"))
                num = Integer.parseInt(command.nextToken());

            switch (run) {
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    sb.append((set.contains(num) ? 1 : 0)+"\n");
                    break;
                case "toggle":
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all":
                    set.clear();
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
            }
            commandLine--;
        }

        System.out.println(sb);
    }
}
