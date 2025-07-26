class Solution {
    public String solution(String new_id) {
        String answer = "";
        String lowercase = new_id.toLowerCase();
        String temp = "";
        for(int i=0; i<lowercase.length(); i++){
            if((lowercase.charAt(i) >= 'a' && lowercase.charAt(i)<='z')
               || lowercase.charAt(i) >= '0' && lowercase.charAt(i) <= '9'
               || lowercase.charAt(i) == '-' || lowercase.charAt(i) == '_'
               || lowercase.charAt(i) == '.'){
                temp += lowercase.charAt(i);
            }
        }
        temp = temp.replaceAll("\\.{2,}", ".");
        
        if(temp.length() > 0 && temp.charAt(0)=='.') temp = temp.substring(1, temp.length());
        if(temp.length() > 0&&temp.charAt(temp.length()-1)=='.') temp = temp.substring(0, temp.length()-1);
        if(temp.length() == 0) temp = "a";
        if(temp.length() >= 16) temp = temp.substring(0, 15);
        if(temp.charAt(temp.length()-1)=='.') temp = temp.substring(0, temp.length()-1);
         System.out.println(temp.length());
        if(temp.length() <= 2) {
            while(temp.length() < 3){
               
                temp += temp.charAt(temp.length()-1);
            }
        }
        return temp;
    }
}