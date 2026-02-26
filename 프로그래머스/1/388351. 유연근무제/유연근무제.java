class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<timelogs.length; i++){
            int curday = startday;
            boolean flag = false;
            
            int minute = schedules[i] % 100 + 10;
            int hour = schedules[i] / 100;
            
            if(minute > 59){
                minute %= 60;
                hour += 1;
            }
            
            int time = hour * 100 + minute;
            
            for(int j=0; j<timelogs[i].length; j++){
                // 주말인 경우 건너뛰기
                if(curday % 7 == 6 || curday % 7 == 0){
                    curday++;
                    continue;
                }
                if(time < timelogs[i][j]){
                    flag = true;
                    break;
                }else{
                    curday++;
                }
            }
            
            answer = (flag) ? answer : answer + 1;
        }
        return answer;
    }
}