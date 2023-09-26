import java.util.*;
class Solution {
    public int solution(String s) {//97~122
        LinkedHashMap<String, Integer>word=new LinkedHashMap<String,Integer>();
        
        String answer = "";
        String sWord="";
        int index=0;
        
        //해시맵에 저장
        word.put("zero",0);
        word.put("one",1);
        word.put("two",2);
        word.put("three",3);
        word.put("four",4);
        word.put("five",5);
        word.put("six",6);
        word.put("seven",7);
        word.put("eight",8);
        word.put("nine",9);
       
        while(index<s.length()){
            sWord="";
            //s[index]가 영어일 때,
            if(s.charAt(index)>=97&&s.charAt(index)<=122){
                 for(int i=index;i<s.length();i++){ 
                      if(!(s.charAt(i)>=97&&s.charAt(i)<=122)) {
                          index=i;
                          break;
                      }else{
                        sWord+=s.charAt(i);
                        if(word.containsKey(sWord)){
                            answer+=word.get(sWord)+"";
                            index=i;
                            break;
                        }
                      }
                 }
                index++;
            }
            //s[index]가 숫자일 때,
            else{
                answer+=s.charAt(index);     
                index++;
            }
        }
        int submit=Integer.valueOf(answer);
        return submit;
    }
}