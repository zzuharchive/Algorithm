import java.util.*;
class ExpirationDate{
    int index;
    int year;
    int month;
    int day;
    
    ExpirationDate(int index, int year, int month, int day){
        this.index = index;
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<ExpirationDate> expiration = new ArrayList<>();
        
        for(int i=0; i < terms.length; i++){
            String[] splited = terms[i].split(" ");
            map.put(splited[0], Integer.parseInt(splited[1]));
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] splited = privacies[i].split(" ");
            String[] dateSplited = splited[0].split("\\.");
            
            int year = Integer.parseInt(dateSplited[0]);
            int month = Integer.parseInt(dateSplited[1]);
            int day = Integer.parseInt(dateSplited[2]);
            
            int temp = 28 * map.get(splited[1]) + day - 1;
            int plusMonth = temp / 28;
            int expirationDay = (temp % 28 == 0) ?  28 : temp % 28;
            int expirationMonth =  month + plusMonth;
            
            year += (expirationMonth - 1) / 12;
            
            if (expirationDay == 28 && (temp % 28 == 0)) {
                expirationMonth -= 1;
                if (expirationMonth == 0) {
                expirationMonth = 12;
                year -= 1;
                }
            }
            
            expirationMonth = (expirationMonth - 1) % 12 + 1;
            
            expiration.add(new ExpirationDate(i + 1, year, expirationMonth, expirationDay));
        }
        
        
        String[] splitToday = today.split("\\.");
        int yearOfToday = Integer.parseInt(splitToday[0]);
        int monthOfToday = Integer.parseInt(splitToday[1]);
        int dayOfToday = Integer.parseInt(splitToday[2]);
        
        for(int i=0; i<expiration.size(); i++){     
            
            if (expiration.get(i).year < yearOfToday) {
                answer.add(expiration.get(i).index);
                continue;
            }
            else if (expiration.get(i).year == yearOfToday && expiration.get(i).month < monthOfToday) {
                answer.add(expiration.get(i).index);
                continue;
            }
            else if (expiration.get(i).year == yearOfToday && expiration.get(i).month == monthOfToday && expiration.get(i).day < dayOfToday) {
                answer.add(expiration.get(i).index);
                continue;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}