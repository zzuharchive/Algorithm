import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] chess=new String[8];
		int whiteHolse = 0;
		for(int i=0; i<8; i++) {
			chess[i] = br.readLine();
		}
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(chess[i].charAt(j)=='F') {
					if(i%2==0 && j%2==0) {
							whiteHolse++;
					}else if(i%2!=0 && j%2!=0){
							whiteHolse++;
					}
				}
			}
		}
		System.out.println(whiteHolse);
	}
}
