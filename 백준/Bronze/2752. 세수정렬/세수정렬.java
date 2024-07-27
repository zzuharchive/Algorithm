import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (st.hasMoreTokens()) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i) + " ");
        }

        System.out.println(sb);
    }
}
