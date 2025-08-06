import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
       
        Map<String, Integer> totalTime = new HashMap<>();
        Map<String, Integer> fee = new HashMap<>();
        Map<String, String> in = new HashMap<>();
        Set<String> cars = new HashSet<>();
        
        for(String record : records){
            String[] splited = record.split(" ");
            cars.add(splited[1]);
            
            if("IN".equals(splited[2])){
                in.put(splited[1], splited[0]);    
            }else if("OUT".equals(splited[2])){
                String inTime = in.get(splited[1]);
                totalTime.put(splited[1], totalTime.getOrDefault(splited[1], 0) + calculateTime(inTime, splited[0]));
                in.remove(splited[1]);
            }
        }
        
        for(String key : in.keySet()){
            String inTime = in.get(key);
            totalTime.put(key, totalTime.getOrDefault(key, 0) + calculateTime(inTime, "23:59"));
        }
        
        for(String car : cars){
            fee.put(car, calculateFee(totalTime.get(car), fees[0], fees[1], fees[2], fees[3]));
        }
        
        int[] answer = fee.entrySet().stream()
                            .sorted(Map.Entry.comparingByKey()) 
                            .mapToInt(Map.Entry::getValue)      
                            .toArray();
       
        return answer;
    }
    
    int calculateFee(int time, int basicTime, int basicFee, int unitTime, int unitFee){
        
        if(time <= basicTime) return basicFee;
        return (int) Math.ceil((double) (time - basicTime) / unitTime) * unitFee + basicFee;
    }
    
    int calculateTime(String inTime, String outTime){
        
        String[] inTimeArr = inTime.split(":");
        String[] outTimeArr = outTime.split(":");
        
        int outHour = Integer.parseInt(outTimeArr[0]);
        int outMinute = Integer.parseInt(outTimeArr[1]);
        int inHour = Integer.parseInt(inTimeArr[0]);
        int inMinute = Integer.parseInt(inTimeArr[1]);
        
        return (outHour - inHour) *  60 + outMinute - inMinute;
    }
}