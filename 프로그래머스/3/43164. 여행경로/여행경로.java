import java.util.*;
class Solution {
    boolean[] used;
    List<String> city = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        
        Arrays.sort(tickets,(a, b)->{
            if(a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        city.add("ICN");
        travel("ICN", 0, tickets);
        
        return city.toArray(new String[0]);
    }
    boolean travel(String start, int usedAmt, String[][] tickets){
        if(usedAmt == tickets.length) return true;
        for(int i=0; i<tickets.length; i++){
            if(used[i]
              || !start.equals(tickets[i][0])) continue;
            
            city.add(tickets[i][1]);
            used[i] = true;
            
            if(travel(tickets[i][1], usedAmt + 1, tickets)){
                return true;
            }
            
            city.remove(city.size() - 1);
            used[i] = false;
        }
        return false;
    }
}