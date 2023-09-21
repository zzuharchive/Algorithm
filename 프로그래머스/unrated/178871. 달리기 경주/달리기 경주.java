import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer=new String[players.length];
        LinkedHashMap <Integer, String> playNum = new LinkedHashMap<Integer, String>();
        LinkedHashMap <String, Integer> playName = new LinkedHashMap<String, Integer>();
        
        for(int i=0;i<players.length;i++){
            //해시맵에 저장
            playName.put(players[i], i+1);
            playNum.put(i+1, players[i]);
        }  
        for(int i=0;i<callings.length;i++){
            //callings에 있는 사람 이름이 불리면
            //해시맵에서 찾아서 등수를 바꿔줌.
            if(playName.containsKey(callings[i])){
                int bfrNum=playName.get(callings[i]);
                String key=playNum.get(bfrNum);
                String temp=playNum.get(bfrNum-1);
                
                playNum.put(bfrNum-1, key);
                playNum.put(bfrNum, temp);
                
                playName.put(key, bfrNum-1);
                playName.put(temp, bfrNum);
            }
        }
        for(int i=0;i<answer.length;i++){
            //해시맵을 통해 출력해줌.
            answer[i]=playNum.get(i+1);
        }
       
        return answer;
    }
}