import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
   
    static LinkedList<Integer>[] graph;
    static boolean[] isVisit;
    static Queue<Integer> queue;
    static int[] sequence;
    static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer setting = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(setting.nextToken());
        int edge = Integer.parseInt(setting.nextToken());
        int start = Integer.parseInt(setting.nextToken());

        //초기화
        isVisit = new boolean[n + 1];
        graph = new LinkedList[n + 1];
        sequence = new int[n + 1];
        queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
            sequence[i] = 0;
        }

        //입력하기
        for (int i = 0; i < edge; i++) {
            StringTokenizer edgeInput = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(edgeInput.nextToken());
            int b = Integer.parseInt(edgeInput.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        reverseBfs(start);

        for (int i = 1; i < sequence.length; i++) {
            System.out.println(sequence[i]);
        }
    }

    static void reverseBfs(int vertex) {
        if (isVisit[vertex]) return;
        isVisit[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sequence[current] = count++;
            for (int next : graph[current]) {
                if (!isVisit[next]) {
                    isVisit[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}