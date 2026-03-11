import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visit;
    static int answer = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int personCount = input.nextInt();
        visit = new boolean[personCount + 1];
        graph = new ArrayList[personCount + 1];

        for (int i = 0; i < personCount + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = input.nextInt();
        int target = input.nextInt();

        int repeat = input.nextInt();
        for (int i = 0; i < repeat; i++) {
            int parent = input.nextInt();
            int child = input.nextInt();

            graph[parent].add(child);
            graph[child].add(parent);
        }
        dfs(start, target, 0);
        System.out.println(answer);
    }

    private static void dfs(int cur, int target, int depth) {
        visit[cur] = true;

        if (cur == target) {
            answer = depth;
        } else {
            for (int i : graph[cur]) {
                if (!visit[i]) {
                    dfs(i, target, depth + 1);
                }
            }
        }
    }
}
