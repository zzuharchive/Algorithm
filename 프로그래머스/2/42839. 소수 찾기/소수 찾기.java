import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> set;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        dfs(numbers, "");
        for(int num : set){
            answer += findPrime(num);
        }
    
        return answer;
    }
    // dfs
    void dfs(String numbers, String num){
        // 종료 조건
        if(!num.equals("")) set.add(Integer.parseInt(num));
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(numbers, num + numbers.charAt(i));
            visited[i] = false; // 백트래킹
        }
    }
    // 소수 판별
    int findPrime(int num){
        if(num < 2) return 0;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0) return 0;
        }
        return 1;
    }
}