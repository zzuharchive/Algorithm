import java.util.*;
class Solution {
    public int solution(String[][] relation) {
    int rows = relation.length;
    int cols = relation[0].length;
    List<Set<Integer>> candidates = new ArrayList<>();
        for(int r = 1; r<=cols; r++){
            List<List<Integer>> combs = new ArrayList<>();
            combine(cols, r, 0, new ArrayList<>(), combs);
            
            for(List<Integer> comb : combs){
                
                boolean minimal = true;
                
                for(Set<Integer> candidate : candidates){
                    if(comb.containsAll(candidate)){
                        minimal = false;
                        break;
                    }
                }
                
                if(!minimal) continue;
            
                Set<String> seen = new HashSet<>();
                for(int i = 0; i < rows; i++){
                    StringBuilder key = new StringBuilder();
                    for(int c : comb){
                        key.append(relation[i][c]).append("|");
                    }
                    seen.add(key.toString());
                }
                
                if(seen.size() == rows){
                    candidates.add(new HashSet<>(comb));
                }
            }
        }
        return candidates.size();
    }
    
    void combine(int n, int r, int start, List<Integer> cur, List<List<Integer>> result){
        if(cur.size() == r){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < n; i++){
            
            cur.add(i);
            combine(n, r, i + 1, cur, result);
            cur.remove(cur.size() - 1); 
        }
    }
}