import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int count = 1;
    static int[] sequence;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        sequence = new int[N + 1];
        isVisit = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            isVisit[i] = false;
            sequence[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer insertEdge = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(insertEdge.nextToken());
            int b = Integer.parseInt(insertEdge.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        reverseDfs(graph, isVisit, R);

        for (int i = 1; i < sequence.length; i++) {
            System.out.println(sequence[i]);
        }
    }

    static void reverseDfs(ArrayList<ArrayList<Integer>> graph, boolean[] isVisit, int vertex) {

        isVisit[vertex] = true;
        sequence[vertex] = count++;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int current = graph.get(vertex).get(i);
            if (!isVisit[current])
                reverseDfs(graph, isVisit, current);
        }
    }
}
