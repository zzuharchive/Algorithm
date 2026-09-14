import java.util.*;
class Solution {
    int[] arr;
    public int solution(int n, int[][] computers) {
        
        arr = new int[n];
        for(int i = 0; i<arr.length; i++){
            arr[i] = i;
        }
        
        for(int i=0; i < n; i++){
            for(int j = 0; j<n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1) union(i, j);
            }
        }
        Set<Integer>set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(find(i));
        }
        return set.size();
    }
    
    void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB) arr[rootB] = rootA;
    }
    
    int find(int a){
        if(arr[a] != a) return arr[a] = find(arr[a]);
        return arr[a];
    }
}