import java.util.*;
class Ticket{
    String from;
    String to;
    boolean used;
    
    Ticket(String from, String to){
        this.from = from;
        this.to = to;
        this.used = false;
    }
}
class Solution {
    List<String> answer = new ArrayList<>();
    List<Ticket> ticketsList = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] ticket : tickets){
            ticketsList.add(new Ticket(ticket[0], ticket[1]));
        }
        
        ticketsList.sort((a, b)->{
            if(a.from.equals(b.from)) return a.to.compareTo(b.to);
            return a.from.compareTo(b.from);
        });
        answer.add("ICN");
        dfs("ICN", 0);
        return answer.toArray(new String[0]);
    }
    
    private boolean dfs(String current, int depth){
        if(depth == ticketsList.size()){
            return true;
        }
        for(int i=0; i<ticketsList.size(); i++){
            Ticket ticket = ticketsList.get(i);
            if(!ticket.used && ticket.from.equals(current)){
                ticket.used = true;
                answer.add(ticket.to);
                if(dfs(ticket.to, depth + 1)) return true;
                answer.remove(answer.size()-1);
                ticket.used = false;
            }
        }
        return false;
    }
}