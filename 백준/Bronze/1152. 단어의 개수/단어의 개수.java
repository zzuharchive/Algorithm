import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	        Scanner input = new Scanner(System.in);
    	        int num=0;
    	        String sentence = input.nextLine();
    	        if(sentence.charAt(0)==' ') num -= 1;
    	        if(sentence.equals(" ")) {
    	        	System.out.println("0");
    	        	return;
    	        }
    	        
    	        String[] arr = sentence.split(" ");
    	      
    	        System.out.println(arr.length+num);
    }
}
