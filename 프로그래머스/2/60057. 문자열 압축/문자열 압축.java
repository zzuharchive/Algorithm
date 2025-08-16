class Solution {
    int min;
    public int solution(String s) {
        min = s.length();
        zip(s, 1);
        return min;
    }
    
    public void zip(String s, int charLength){
        
        if(charLength > s.length()) return;
       
        StringBuilder str = new StringBuilder();
        String pre = s.substring(0, charLength);
        int count = 1;
        int idx = charLength;
        
        while(idx + charLength <= s.length()){
            
            String cur = s.substring(idx, idx+charLength);
            if(cur.equals(pre)) count++;
            else{
                if(count > 1) str.append(count);
                str.append(pre);
                pre = cur;
                count = 1;
            }
            idx += charLength;
        }
        
        if(count > 1) str.append(count);
        str.append(pre);
        
        if(idx < s.length()) str.append(s.substring(idx));
        
        min = Math.min(min, str.toString().length());
        zip(s, charLength + 1);
    }
    
    
}