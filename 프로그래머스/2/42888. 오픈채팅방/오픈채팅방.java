import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] str = record[i].split(" ");
            if(!str[0].equals("Leave")){
                map.put(str[1], str[2]);
            }
        }
        
        for(int i=0; i<record.length; i++){
            String[] str = record[i].split(" ");
            String nickname = map.get(str[1]);
            switch(str[0]){
                case "Enter" -> answer.add(nickname + "님이 들어왔습니다.");
                case "Leave" -> answer.add(nickname + "님이 나갔습니다.");
            }
        }
        return answer.toArray(new String[0]);
    }
}