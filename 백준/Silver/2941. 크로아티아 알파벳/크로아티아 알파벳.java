import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cnt = 0;
			
		String str = input.next();
		for(int i=str.length()-1; i>=0;i--) {
			
			cnt++;
			if(i>0) {
			switch(str.charAt(i)){
			case '=':
				if(str.charAt(i-1)=='c'||str.charAt(i-1)=='s') {
					i-=1;
					continue;
				}
				else if(str.charAt(i-1)=='z') {
					if(i>1&&str.charAt(i-2)=='d') {
						i-=2;
						continue;
					}else {
					i-=1;
					continue;
					}	
				}
			case '-':
				if(str.charAt(i-1)=='c'||str.charAt(i-1)=='d') {
					i-=1;
					continue;
				}
			case 'j':
				if(str.charAt(i-1)=='l'||str.charAt(i-1)=='n') {
					i-=1;
					continue;
				}
			}
			}
		}
		System.out.println(cnt);
		
		
		}
	}


