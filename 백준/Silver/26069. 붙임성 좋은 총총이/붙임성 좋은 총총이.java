import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        boolean meet = false;

        for (int i = 0; i < N; i++) {

            String names = br.readLine();
            StringTokenizer st = new StringTokenizer(names, " ");
            String A = st.nextToken();
            String B = st.nextToken();

            if (!meet && (A.equals("ChongChong") || B.equals("ChongChong"))) {
                set.add(A);
                set.add(B);
                meet = true;
                continue;
            }
            if (!set.contains(A) && !set.contains(B)) continue;
            if (meet && !set.contains(A)) set.add(A);
            if (meet && !set.contains(B)) set.add(B);
        }

        System.out.println(set.size());
    }
}
