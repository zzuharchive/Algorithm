import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        Set<Integer>[] dp = new HashSet[9];
        
        for(int i=1; i<=8; i++){
            dp[i] = new HashSet<>();
        }
     
        int repeat = 0;
        
        for(int i=1; i<=8; i++){
            
            repeat = repeat * 10 + N;
            dp[i].add(repeat);
            
            for(int k = 1; k < i; k++){
                for(int a : dp[k]){
                    for(int b : dp[i-k]){
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        
                        if(b != 0)  dp[i].add(a / b);
                    }
                }
            }
            
            if(dp[i].contains(number)) return i;
        }
        return -1;
    }
}