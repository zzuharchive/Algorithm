import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        int[] distance = new int[words.length];
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<words.length; i++){
            if(charComp(begin, words[i])) {
                q.offer(i);
                distance[i] = 1;
            }
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            if(words[cur].equals(target)) return distance[cur];
            for(int i=0; i<words.length; i++){
                if(cur == i || visited[i]
                   || !charComp(words[cur], words[i])) 
                    continue;
                visited[i] = true;
                q.offer(i);
                distance[i] = distance[cur] + 1;
            }
        }
        
        return 0;
    }
    boolean charComp(String target1, String target2){
        int equalnum = 0;
        for(int i=0; i<target1.length(); i++){
            if(target1.charAt(i) == target2.charAt(i))
                equalnum++;
        }
        return (equalnum == target1.length() - 1);
    }
}