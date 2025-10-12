import java.util.*;

class Solution {
    String[] head;
    int[] num;
    String[] tail;
    
    public String[] solution(String[] files) {
        head = new String[files.length];
        num = new int[files.length];
        tail = new String[files.length];
        
        parseFileName(files);
        
        Integer[] order = new Integer[files.length];
        for(int i=0; i<files.length; i++) order[i] = i;
        
        Arrays.sort(order, (a, b)->{
            int c = head[a].compareTo(head[b]);
            if(c!=0) return c;
            c = Integer.compare(num[a], num[b]);
            if(c!=0) return c;
            
            return Integer.compare(a, b);
        });
        
        String[] answer = new String[files.length];
        for(int k=0; k<order.length; k++) answer[k] = files[order[k]];
        
        return answer;
    }
    private void parseFileName(String[] files){       
         for(int i=0; i<files.length; i++){
            StringBuilder nowHead = new StringBuilder();
            StringBuilder nowNum = new StringBuilder();
            StringBuilder nowTail = new StringBuilder();
            int flag = 0;
            
            for(int j =0; j<files[i].length(); j++){
                // head 구하기, tail 구하기
                if(!Character.isDigit(files[i].charAt(j))){
                    if(flag == 0 && nowNum.length() == 0) nowHead.append(files[i].charAt(j));
                    else{
                        nowTail.append(files[i].charAt(j));
                        flag = 1;
                    } 
                } 
                // num 구하기, tail 구하기
                else{
                    if(flag == 0 && nowNum.length() < 5){
                        nowNum.append(files[i].charAt(j));
                    }  else nowTail.append(files[i].charAt(j));
                }
            }
            
            head[i] = nowHead.toString().toLowerCase();
            num[i] = (nowNum.length() == 0) ? 0 : Integer.parseInt(nowNum.toString());
            tail[i] = nowTail.toString();
        }
    }
}