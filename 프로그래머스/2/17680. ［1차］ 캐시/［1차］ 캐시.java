import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;
        
        List<String> dataList = new ArrayList<>(); 
        
        for(int i=0; i<cities.length; i++){
           
            String city = cities[i].toLowerCase();
            
            if(cacheSize == 0 ) {
                totalTime = cities.length * 5;
                break;
            }
            
            if(dataList.contains(city)){
                totalTime += 1;
                int idx = dataList.indexOf(city);
                dataList.remove(idx);
                dataList.add(city);
            }else{
                totalTime += 5;
                // 캐시 자리가 남은 경우
                if(dataList.size() < cacheSize){
                    dataList.add(city);
                }
                // 캐시 자리가 없는 경우
                else if(dataList.size() == cacheSize){
                    String removeCity = dataList.get(0);
                    dataList.remove(0);
                    dataList.add(city);
                }
            }
        }
        return totalTime;
    }
}