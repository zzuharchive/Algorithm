import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String val1 = "";
        String val2 = "";
        int val3 = 0;
        String res="";
        boolean isTrue1=false,isTrue2=false,isTrue3=false;

        String[] color={"black","brown","red","orange",
                "yellow","green","blue","violet","grey","white"};

        String first=input.next();
        String second=input.next();
        String third= input.next();

        for(int i=0;i< color.length;i++){
            if(isTrue1&&isTrue2&&isTrue3) break;
            if(color[i].equals(first)) {
                val1 = i+"";
                isTrue1=true;
            }
            if(color[i].equals(second)){
                val2 = i+"";
                isTrue2=true;
            }
            if(color[i].equals(third)){
                val3 = i;
                isTrue3=true;
            }
        }
        if(val1.equals("0")){
            if(val2.equals("0")){
                System.out.println("0");
                return;
            }
            res=val2;
        }
        else res=val1+val2;
        for(int i=0;i<val3;i++){

            res+="0";
        }
        System.out.println(res);
    }
}
