import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i <= yellow; i++){
            if(yellow%i == 0) list.add(i);
        }
        
        for(int i=0; i<list.size(); i++){
            int yellowY = list.get(i);
            int yellowX = yellow / yellowY;
            int x = yellowX + 2;
            int y = yellowY + 2;
            
            if(x>=y && x*y == brown+yellow){
                answer = new int[]{x, y};
            }
        }
        
        return answer;
    }
}