import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] isVisit;
    static Queue<Integer> queue;
    static LinkedList<Integer>[] graph;
    static int[] inputSeq;
    static int num = 0;
    static int chk = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexAll = Integer.parseInt(br.readLine());
        isVisit = new boolean[vertexAll + 1];
        graph = new LinkedList[vertexAll + 1];
        queue = new LinkedList<>();
        inputSeq = new int[vertexAll];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < vertexAll - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        StringTokenizer seq = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < inputSeq.length; i++) {
            inputSeq[i] = Integer.parseInt(seq.nextToken());
        }
        bfs(1);
        System.out.println(chk);
    }

    static void bfs(int vertex) {

        if (isVisit[vertex]) return;
        isVisit[vertex] = true;
        queue.add(vertex);
        int next = 0;
        while (!queue.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            int current = queue.poll();

            for (int tempNext : graph[current]) {
                if (!isVisit[tempNext]) {
                    set.add(tempNext);
                }
            }
            while (!set.isEmpty()) {
                if (set.contains(inputSeq[num + 1])) {
                    next = inputSeq[num + 1];
                    num++;
                } else {
                    chk = 0;
                    return;
                }

                if (!isVisit[next]) {
                    isVisit[next] = true;
                    set.remove(next);
                    queue.add(next);
                }
            }
        }
    }
}

