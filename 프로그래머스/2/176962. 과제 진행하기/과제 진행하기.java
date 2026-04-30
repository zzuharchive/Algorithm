import java.util.*;

class HomeWork implements Comparable<HomeWork>{
    String subject;
    int start;
    int playtime;
    
    HomeWork(String subject, String start, String playtime){
        this.subject = subject;
        this.start = toMinute(start);
        this.playtime = Integer.parseInt(playtime);
    }
    
    private int toMinute(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    @Override
    public int compareTo(HomeWork hw){
        return this.start - hw.start;
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        HomeWork[] homeworks = new HomeWork[plans.length];
        
        for(int i=0; i<plans.length; i++){
            homeworks[i] = new HomeWork(plans[i][0], plans[i][1], plans[i][2]);
        }
        
        Arrays.sort(homeworks);
        ArrayDeque<HomeWork> stack = new ArrayDeque<>();
        int index = 0;
        
        for(int i=0; i<homeworks.length - 1; i++){
            HomeWork cur = homeworks[i];
            HomeWork next = homeworks[i+1];
            
            int availableTime = next.start - cur.start;
            
            if(cur.playtime <= availableTime){
                answer[index++] = cur.subject;
                availableTime -= cur.playtime;
                
                while(availableTime > 0 && !stack.isEmpty()){
                    HomeWork paused = stack.pollLast();
                    
                    if(paused.playtime <= availableTime){
                        answer[index++] = paused.subject;
                        availableTime -= paused.playtime;
                    } else{
                        paused.playtime -= availableTime;
                        stack.add(paused);
                        availableTime = 0;
                    }
                }
            }
            
            else{
                cur.playtime -= availableTime;
                stack.add(cur);
            }
        }
        answer[index++] = homeworks[homeworks.length - 1].subject;
        while(!stack.isEmpty()){
            answer[index++] = stack.pollLast().subject;
        }
        
        return answer;
    }
}