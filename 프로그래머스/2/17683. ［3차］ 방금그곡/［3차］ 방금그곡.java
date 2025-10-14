import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replaceSharp(m);
        int latestTime = -1;
        
        
        for(int i=0; i<musicinfos.length; i++){
            String[] str = musicinfos[i].split(",");
            int musicTime = hourToMinute(str[1]) - hourToMinute(str[0]);
            String title = str[2];
            String melody = replaceSharp(str[3]);
            
            StringBuilder playMelody = new StringBuilder();
            
            if(musicTime < melody.length()) {
                playMelody.append(melody.substring(0, musicTime));
            }               
            else if(musicTime == melody.length()) {
                playMelody.append(melody);
            }
            else{
                while(playMelody.length() < musicTime){
                    int lastLength = musicTime - playMelody.length();
                    
                    if(lastLength >= melody.length()){
                        playMelody.append(melody);
                    }else if(lastLength < melody.length()){
                        playMelody.append(melody.substring(0, lastLength));
                    }       
                }
            }
            
            if(playMelody.toString().contains(m) && latestTime < musicTime) {
                
                answer = title;
                latestTime = musicTime;
            }
        }
        return answer;
    }
    
    public int hourToMinute(String time){
        String[] timeInfo = time.split(":");
        return Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
    }
    
    public String replaceSharp(String melody){
        melody = melody.replace("A#", "a");
        melody = melody.replace("B#", "b");
        melody = melody.replace("C#", "c");
        melody = melody.replace("D#", "d");
        melody = melody.replace("E#", "e");
        melody = melody.replace("F#", "f");
        melody = melody.replace("G#", "g");
        
        return melody;
    }
}