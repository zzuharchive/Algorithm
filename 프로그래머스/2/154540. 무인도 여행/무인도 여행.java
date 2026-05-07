import java.util.*;
class Solution {
    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {1, -1, 0, 0};
    public static boolean[][] visited;
    public int[] solution(String[] maps) {
        List<Integer> temp = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X') {
                    temp.add(dfs(i, j, maps));
                }
            }
        }
        
        int[] answer = new int[temp.size()];
        answer = temp.stream().sorted().mapToInt(Integer::intValue).toArray();
        return (answer.length == 0)?new int[]{-1}:answer;
    }
    
    public int dfs(int x, int y, String[] maps){
        int sum = Integer.parseInt(maps[x].charAt(y)+"");
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < maps.length && ny >=0 && ny <maps[0].length()){
                if(!visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                   sum += dfs(nx, ny, maps); 
                }
            }
        }
        return sum;
    }
}