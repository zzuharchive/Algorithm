import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            t--;
            boolean thisError = false;
            boolean reverse = false;

            //수행할 함수의 개수
            String p = br.readLine();
            //원소의 개수
            long n = Integer.parseInt(br.readLine());

            Deque<Integer> integer = new LinkedList<>();

            //원소 파싱
            String insertArr = br.readLine();
            insertArr = insertArr.substring(1, insertArr.length()-1);

            StringTokenizer st = new StringTokenizer(insertArr, ",");

            for (int i = 0; i < n; i++) {
                integer.add(Integer.parseInt(st.nextToken()));
            }

            //함수 실행
            for (int i = 0; i < p.length(); i++) {

                switch (p.charAt(i)) {
                    case 'R':
                        reverse = !reverse;
                        break;
                    case 'D':
                        if (integer.size() == 0) {
                            thisError = true;
                            i = p.length() - 1;
                        } else {
                            if (reverse) integer.removeLast();
                            else integer.removeFirst();
                        }
                        break;
                }
            }

            if (thisError) {
                sb.append("error\n");
                continue;
            }

            //결과값 저장
            if(integer.isEmpty()) {
                sb.append("[]\n");
                continue;
            }

            sb.append("[");
            while (!integer.isEmpty()) {

                if (!reverse) {
                    if (integer.size() == 1) sb.append(integer.removeFirst() + "]\n");
                    else sb.append(integer.removeFirst() + ",");
                } else {
                    if (integer.size() == 1) sb.append(integer.removeLast() + "]\n");
                    else sb.append(integer.removeLast() + ",");
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

}
