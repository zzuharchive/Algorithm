import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer setting = new StringTokenizer(br.readLine()," ");

        int count = 0;
        int s = Integer.parseInt(setting.nextToken());
        int p = Integer.parseInt(setting.nextToken());
        int start = 0;
        int end = p-1;
        HashMap<Character, Integer> standard = new HashMap<>();
        HashMap<Character, Integer> inputChar = new HashMap<>();

        String dna = br.readLine();
        StringTokenizer inputStandard = new StringTokenizer(br.readLine()," ");

        standard.put('A',Integer.parseInt(inputStandard.nextToken()));
        standard.put('C',Integer.parseInt(inputStandard.nextToken()));
        standard.put('G',Integer.parseInt(inputStandard.nextToken()));
        standard.put('T',Integer.parseInt(inputStandard.nextToken()));

        inputChar.put('A', 0);
        inputChar.put('C', 0);
        inputChar.put('G', 0);
        inputChar.put('T', 0);


        for(int i=0; i<p;i++){
            char now = dna.charAt(i);
            if(inputChar.containsKey(now)){
                inputChar.replace(now, inputChar.get(now)+1);
            }
        }

        while(true){
            
            // 포함되어야 하는 최소 개수를 만족하는 경우
            if(inputChar.get('A') >= standard.get('A')){
                if(inputChar.get('C') >= standard.get('C')){
                    if(inputChar.get('G') >= standard.get('G')){
                        if(inputChar.get('T') >= standard.get('T')) {
                            count++;
                        }
                    }
                }
            }

            // 슬라이딩 전
            if(inputChar.containsKey(dna.charAt(start))){
                inputChar.replace(dna.charAt(start), inputChar.get(dna.charAt(start++))-1);
            }

            if(end==s-1) break;
            //슬라이딩 후
            if(inputChar.containsKey(dna.charAt(++end))){
                inputChar.replace(dna.charAt(end), inputChar.get(dna.charAt(end))+1);
            }


        }

        System.out.println(count);
    }
}
