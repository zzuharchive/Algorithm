import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static boolean[] isVisit;
    static int[] seq;
    static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //정점 개수
        int N = Integer.parseInt(st.nextToken());
        //간선의 수
        int M = Integer.parseInt(st.nextToken());
        //시작노드
        int R = Integer.parseInt(st.nextToken());


        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(N + 1);
        isVisit = new boolean[N + 1];
        seq = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            isVisit[i] = false;
            graph.add(new ArrayList<>());
            seq[i] = 0;
        }


        //간선입력
        for (int i = 0; i < M; i++) {
            StringTokenizer insertEdge = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(insertEdge.nextToken());
            int b = Integer.parseInt(insertEdge.nextToken());

            //무방향
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //오름차순으로 정렬
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        dfs(graph, isVisit, R);

        for (int i = 1; i < seq.length; i++) {
            System.out.println(seq[i]);
        }

    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] isVisit, int vertex) {
        isVisit[vertex] = true;
        seq[vertex] = count++;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int current = graph.get(vertex).get(i);
            if (!isVisit[current])
                dfs(graph, isVisit, current);
        }
    }
}
