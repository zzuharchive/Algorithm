import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static boolean[] isVisit;
    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n + 1);
        isVisit = new boolean[n + 1];
        parents = new int[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            isVisit[i] = false;
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer vertex = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(vertex.nextToken());
            int b = Integer.parseInt(vertex.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(graph, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int vertex) {
        
        isVisit[vertex] = true;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int next = graph.get(vertex).get(i);
            if (!isVisit[next]) {
                parents[next] = vertex;
                dfs(graph, graph.get(vertex).get(i));
            }
        }
    }
}
