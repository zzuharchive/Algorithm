import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] setting = br.readLine().split(" ");
        int vertex = Integer.parseInt(setting[0]);
        int edge = Integer.parseInt(setting[1]);
        int start = Integer.parseInt(setting[2]);

        initVisit(vertex);

        for (int i = 0; i <= vertex; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            String[] input = br.readLine().split(" ");
            int num1 = Integer.parseInt(input[0]);
            int num2 = Integer.parseInt(input[1]);

            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(start);
        initVisit(vertex);
        sb.append("\n");
        bfs(start);

        System.out.println(sb);
    }

    // 재귀를 사용한 dfs
    static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int num : graph.get(start)) {
            if (!visited[num]) {
                dfs(num);
            }
        }
    }

    // bfs
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int num : graph.get(cur)) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }

    // 방문 배열 생성
    static void initVisit(int size) {
        visited = new boolean[size + 1];
    }

}
