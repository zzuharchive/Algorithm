import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[5];
        LinkedList<Integer>[] arrayList = new LinkedList[5];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int timeSum = 0;
        for (int i = 0; i < rank.length; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
            arrayList[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer setting = new StringTokenizer(br.readLine(), " ");
            int ranking = Integer.parseInt(setting.nextToken());
            int time = Integer.parseInt(setting.nextToken());

            arrayList[ranking - 1].add(time);
        }
        for (int i = 0; i < 5; i++) {
            Collections.sort(arrayList[i]);
        }

        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < rank[i]; j++) {
                timeSum += arrayList[i].get(j);
                if (j == rank[i] - 1) timeSum += 60;
                else timeSum += arrayList[i].get(j + 1) - arrayList[i].get(j);
            }
            if (i == rank.length - 1) timeSum -= 60;
        }
        System.out.println(timeSum);
    }
}
