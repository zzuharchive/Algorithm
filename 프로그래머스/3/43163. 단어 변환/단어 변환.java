import java.util.*;

class Word{
    String word;
    int num;
    
    Word(String word, int num){
        this.word = word;
        this.num = num;
    }
}

class Solution {

    public int solution(String begin, String target, String[] words) {
        
        return bfs(begin, target, words);       
    }
    
    public int bfs(String begin, String target, String[] words){
        
        Queue<Word> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(new Word(begin, 0));

        while(!queue.isEmpty()){
            Word current = queue.poll();
           
            if(current.word.equals(target)){
                return current.num;
            }
            
            for(int i=0; i<words.length; i++){
                if(checkWord(current.word, words[i])&&!visited.contains(words[i])){
                    queue.offer(new Word(words[i], current.num+1));
                    visited.add(words[i]);
                }
            }
        }
        return 0;
    }
    
    public boolean checkWord(String current, String word){
        int matchNum =0;
        for(int i=0; i<current.length(); i++){
            if(current.charAt(i)!=(word.charAt(i))) {
                matchNum++;
            }
        }
        return (matchNum == 1)? true : false;
    }
}