import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        
        
        ArrayList<String> str1List = transStrToList(str1.toLowerCase());
        ArrayList<String> str2List = transStrToList(str2.toLowerCase());
        
        int intersectionValue = getIntersection(str1List, str2List);
        int sumValue = str1List.size() + str2List.size() - intersectionValue;
        
        if(sumValue == 0) return 65536;
        
        double j = (double) intersectionValue / sumValue;
        return (int) Math.floor(j * 65536);
    }
    
    public ArrayList<String> transStrToList (String str){
        ArrayList<String> setList = new ArrayList<>();
        
        for(int i=0; i<str.length() - 1; i++){
            if(!Character.isLetter(str.charAt(i)) 
               || !Character.isLetter(str.charAt(i+1))) continue;
            
            setList.add(String.valueOf(str.charAt(i)) +String.valueOf(str.charAt(i+1)));
        }
    
        return setList;
    }
    
    public int getIntersection(List<String> str1List, List<String> str2List){
        
        int count = 0;
        
        List<String> copy = new ArrayList<>(str1List);
        for(String str2 : str2List){
            if(copy.contains(str2)){
                count++;
                copy.remove(str2);
            }
        }
        return count;
    }
}