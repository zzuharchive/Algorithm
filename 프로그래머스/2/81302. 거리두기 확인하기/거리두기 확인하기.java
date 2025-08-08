import java.util.*;

class Solution {
    int[] answer;
    public int[] solution(String[][] places) {
        
        answer = new int[places.length];
        int index = 0;
        
        for(String[] place : places){
            List<int[]> people = new ArrayList<>();
           
            for(int i=0; i<place.length;i++){
                for(int j=0; j<place[i].length(); j++){
                    if(place[i].charAt(j) == 'P') {
                        people.add(new int[]{i, j});
        
                    }
                }
            } 
        
            answer[index++] = checkRule(place, people);
        }
        
        
        return answer;
    }
    
    int getDistance(int p1x, int p1y, int p2x, int p2y){
        return Math.abs(p1x - p2x) + Math.abs(p1y - p2y);
    }
    
    int checkRule(String[] place, List<int[]> people){
        
        for(int i = 0; i<people.size(); i++){
            int p1x = people.get(i)[0];
            int p1y = people.get(i)[1];
            for(int j = i + 1; j<people.size(); j++){
                int p2x = people.get(j)[0];
                int p2y = people.get(j)[1];
                int distance = getDistance(p1x, p1y, p2x, p2y);
                if(distance > 2) {
                    continue;
                }else if(distance == 1){
                    return 0;
                }else if(distance == 2 && 
                         !hasWall(place, p1x, p1y, p2x, p2y)){
                    return 0;
                }
            }
        }
        return 1;
    }
    
    boolean hasWall(String[] place, int p1x, int p1y, int p2x, int p2y){
        if(p1x == p2x) return place[p1x].charAt((p1y + p2y) / 2) == 'X';
        else if(p1y == p2y) return place[(p1x+p2x)/2].charAt(p1y) == 'X';
        else{
            return place[p1x].charAt(p2y) == 'X' && place[p2x].charAt(p1y) == 'X';
        }
    }
}