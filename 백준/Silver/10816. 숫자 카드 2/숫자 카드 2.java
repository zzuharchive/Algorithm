import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<Integer, Integer> numCardCount = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int[] numArr = new int[a];

        String numArrStr = br.readLine();
        StringTokenizer st = new StringTokenizer(numArrStr, " ");

        //상근이가 가진 숫자카드
        for (int i = 0; i < a; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        //상근이가 가진 숫자카드의 개수
        for (int i = 0; i < numArr.length; i++) {
            if (!numCardCount.containsKey(numArr[i])) {
                numCardCount.put(numArr[i], 1);
            } else numCardCount.replace(numArr[i], numCardCount.get(numArr[i]) + 1);
        }

        //비교해야 하는 숫자카드 그룹
        int b = Integer.parseInt(br.readLine());
        int[] keyArr = new int[b];

        String keyArrStr = br.readLine();
        st = new StringTokenizer(keyArrStr, " ");
        for (int i = 0; i < b; i++) {
            keyArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < keyArr.length; i++) {
            if (!numCardCount.containsKey(keyArr[i])) sb.append("0 ");
            else sb.append(numCardCount.get(keyArr[i]) + " ");
        }
        System.out.println(sb);
    }
}



