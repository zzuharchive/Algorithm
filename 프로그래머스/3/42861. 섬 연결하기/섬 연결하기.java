import java.util.*;
class Solution {
    public static int[] arr;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = i;
        }
        
        Arrays.sort(costs, (a, b)->Integer.compare(a[2],b[2]));
        
        int count = 0;
        
        for(int i = 0; i<costs.length; i++){
            int vertex1 = costs[i][0];
            int vertex2 = costs[i][1];
            
            if(find(vertex1) == find(vertex2)) continue;
            
            union(vertex1, vertex2);
            answer += costs[i][2];
            if(++count == n-1) break;
        }
        
        return answer;
    }
    
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB){
            arr[rootB] = rootA;
        }
    }
    
    public int find(int x){
        if(x == arr[x]) return x;
        return find(arr[x]);
    }
}