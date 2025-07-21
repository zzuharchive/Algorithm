import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int[][] record = new int[friends.length][friends.length];
        int[][] calGift = new int[friends.length][3];
        HashMap<String, Integer> characterIndex = new HashMap<>();
        int[] nextMonthGift = new int[friends.length];
        
        for(int i=0; i<friends.length;i++){
            characterIndex.put(friends[i], i);
        }
        
        for(int i=0; i<gifts.length; i++){
            String[] splited = gifts[i].split(" ");
            String from = splited[0];
            String to = splited[1];
            record[characterIndex.get(from)][characterIndex.get(to)]++;
            calGift[characterIndex.get(from)][0]++;
            calGift[characterIndex.get(to)][1]++;
        }
        
        for(int i=0; i<calGift.length;i++){
            calGift[i][2] = calGift[i][0] - calGift[i][1];
        }
        
        for(int i=0; i<record.length; i++){
            for(int j = i + 1; j<record[i].length; j++){
                if(record[i][j]>record[j][i]){
                    nextMonthGift[i]++;
                }else if(record[i][j] < record[j][i]){
                    nextMonthGift[j]++;
                }else{
                    if(calGift[i][2] > calGift[j][2]){
                        nextMonthGift[i]++;
                    }else if(calGift[i][2] <  calGift[j][2]){
                        nextMonthGift[j]++;
                    }
                }
            }
        }
        
        int max = nextMonthGift[0];
        for(int i=1; i<nextMonthGift.length; i++){
            max = (max<nextMonthGift[i]) ? nextMonthGift[i] : max;
        }
        
        return max;
    }    
}