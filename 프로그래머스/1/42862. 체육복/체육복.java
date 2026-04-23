import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n+1];
        Arrays.fill(clothes, 1);
        
        for(int l : lost){
            clothes[l]--;
        }
        for(int r : reserve){
            clothes[r]++;
        }
        
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            
            int curClothes = clothes[i];
            if(curClothes == 0){
                if(i >= 2 && clothes[i-1] > 1){
                    clothes[i-1]--;
                    clothes[i]++;
                    answer++;
                }else if(i < n && clothes[i+1] > 1){
                    clothes[i+1]--;
                    clothes[i]++;
                    answer++;
                }
            }else if(curClothes >= 1) answer++;
        }

        return answer;
    }
}