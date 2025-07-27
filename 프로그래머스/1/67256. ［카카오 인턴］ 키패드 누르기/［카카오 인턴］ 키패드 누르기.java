import java.util.*;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Point lastLeft = new Point(3, 0);
        Point lastRight = new Point(3, 2);
        HashMap<Integer, Point> map = new HashMap<>();
        map.put(0, new Point(3, 1));
        map.put(1, new Point(0, 0));
        map.put(2, new Point(0, 1));
        map.put(3, new Point(0, 2));
        map.put(4, new Point(1, 0));
        map.put(5, new Point(1, 1));
        map.put(6, new Point(1, 2));
        map.put(7, new Point(2, 0));
        map.put(8, new Point(2, 1));
        map.put(9, new Point(2, 2));
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += 'L';
                lastLeft = map.get(numbers[i]);
            }
               
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += 'R';
                lastRight = map.get(numbers[i]);
            }
               
            else{
                Point now = map.get(numbers[i]);
                
                int distanceFromLeft = Math.abs(lastLeft.x - now.x) + Math.abs(lastLeft.y - now.y);
                int distanceFromRight = Math.abs(lastRight.x - now.x) + Math.abs(lastRight.y - now.y);
                
            System.out.println(numbers[i]+" "+distanceFromLeft+" "+distanceFromRight);
                if(distanceFromLeft == distanceFromRight){
                    if("left".equals(hand)){
                        answer += 'L';
                        lastLeft = now;
                    }else if("right".equals(hand)){
                        answer += 'R';
                        lastRight = now;   
                    }
                }else{
                    if(distanceFromLeft > distanceFromRight){
                        answer += 'R';
                        lastRight = now;
                    }else if(distanceFromLeft < distanceFromRight){
                        answer += 'L';
                        lastLeft = now;
                    }
                }
            }
        }
        return answer;
    }
}