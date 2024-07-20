import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisit;
    static int count = 0;
    static LinkedList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int network = Integer.parseInt(br.readLine());

        graph = new LinkedList[computer + 1];
        isVisit = new boolean[computer + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }


        for (int i = 0; i < network; i++) {
            StringTokenizer connection = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(connection.nextToken());
            int b = Integer.parseInt(connection.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.println(count);
    }

    static void dfs(int vertex) {
        if (isVisit[vertex]) return;
        isVisit[vertex] = true;

        for (int i = 0; i < graph[vertex].size(); i++) {
            int current = graph[vertex].get(i);

            if (!isVisit[current]) {
                dfs(current);
                count++;
            }
        }
    }
}
