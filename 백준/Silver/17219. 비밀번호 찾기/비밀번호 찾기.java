import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();

        StringTokenizer setting = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(setting.nextToken());
        int n = Integer.parseInt(setting.nextToken());

        while (m > 0) {
            StringTokenizer string = new StringTokenizer(br.readLine(), " ");
            String site = string.nextToken();
            String password = string.nextToken();
            map.put(site, password);
            m--;
        }

        while (n > 0) {
            String searchPassword = map.get(br.readLine());
            sb.append(searchPassword + "\n");
            n--;
        }

        System.out.println(sb);

    }
}
