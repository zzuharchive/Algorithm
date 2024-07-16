import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isVisit;
    static int[] order;
    static int index = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        isVisit = new boolean[n + 1];
        order = new int[n + 1];
        int[] position = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer vertex = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(vertex.nextToken());
            int b = Integer.parseInt(vertex.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(st.nextToken());
            position[order[i]] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            graph.get(i).sort(Comparator.comparingInt(o -> position[o]));
        }

        if (order[0] != 1) {
            System.out.println(0);
            return;
        }

        if (dfs(1) && index == n) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static boolean dfs(int vertex) {

        if (order[index++] != vertex) return false;

        isVisit[vertex] = true;

        for (int next : graph.get(vertex)) {
            if (!isVisit[next]) {
                if (!dfs(next)) return false;
            }
        }
        return true;
    }
}