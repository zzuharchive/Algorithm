import java.util.*;
class Solution {
    static int[] unionArr;
    public int solution(int n, int[][] computers) {
        
        unionArr = new int[n];
        for(int i = 0; i<n; i++){
            unionArr[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j=0; j < n; j++){
                if(i == j || computers[i][j] == 0) continue;
                union(i, j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(find(i));
        }
        
        return set.size();
    }
    public int find(int x){
        if(unionArr[x] == x) return x;
        return unionArr[x] = find(unionArr[x]);
    }
    
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA!=rootB){
            unionArr[rootB] = rootA;
        }
    }
}