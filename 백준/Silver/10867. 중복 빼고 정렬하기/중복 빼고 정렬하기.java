import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Set<Integer> set = new HashSet<>();

        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> integerArrayList = new ArrayList<>(set);

        Collections.sort(integerArrayList);
        for (int i : integerArrayList) {
            System.out.printf(i + " ");
        }
    }
}
