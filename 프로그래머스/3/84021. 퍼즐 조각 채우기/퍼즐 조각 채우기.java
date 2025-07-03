import java.util.*;
class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n = game_board.length;
        
        List<List<int[]>> emptyList = new ArrayList<>();
        List<List<int[]>> blockList = new ArrayList<>();
       
        boolean[][]emptyVisited = new boolean[n][n];
        boolean[][]blockVisited = new boolean[n][n];
        
        // 빈칸&블럭 추출
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                if(!emptyVisited[i][j] && game_board[i][j] == 0){
                    List<int[]> emptyBlock = new ArrayList<>();
                    emptyList.add(normalize(extractDfs(i, j, emptyBlock, game_board, emptyVisited, 0)));
                }
                if(!blockVisited[i][j] && table[i][j] == 1){
                    List<int[]> block = new ArrayList<>();
                    blockList.add(extractDfs(i, j, block, table, blockVisited, 1));
                }
            }
        }
        
        boolean[] used = new boolean[blockList.size()];
     
        // 블럭 맞추기
        for(List<int[]> empty : emptyList){
            boolean matched = false;
            for(int i=0; i<blockList.size(); i++){
                if(matched) break;
                else if(used[i]) continue;
                List<int[]> currentBlock =  blockList.get(i);
                for(int r = 0; r < 4; r++){
                    currentBlock = rotate(currentBlock);
                    if(isFit(empty, currentBlock)){
                        answer += currentBlock.size();
                        used[i] = true;
                        matched = true;
                        break;
                    }   
                }
            }
        }
        return answer;
    }
    
    boolean isFit(List<int[]> empty, List<int[]> currentBlock){
        if(empty.size() != currentBlock.size()) return false;
        for(int i=0; i<empty.size(); i++){
            if(!Arrays.equals(empty.get(i), currentBlock.get(i))) return false;
        }
        return true;
    }
    
    // 추출 dfs
    List<int[]> extractDfs(int i, int j, List<int[]> square, int[][] squares, boolean[][] visited, int target){
        if(i>=squares.length||i<0||j>=squares[0].length||j<0) return square;
        if(visited[i][j] || squares[i][j] != target) return square;
        
        visited[i][j] = true;
        square.add(new int[]{i, j});
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};        
        for (int d = 0; d < 4; d++) {
            extractDfs(i + dx[d], j + dy[d], square, squares, visited, target);
        }
        return square;
    }
    List<int[]> normalize(List<int[]> shape){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int[] s : shape){
            minX = Math.min(minX, s[0]);
            minY = Math.min(minY, s[1]);
        }
        
        List<int[]> result = new ArrayList<>();
        for(int[] b : shape){
            result.add(new int[] {b[0] - minX, b[1] - minY});
        }
        
        result.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        return result;
    }
    // 블럭 회전 함수
    public List<int[]> rotate(List<int[]> block){
        List<int[]> rotated = new ArrayList<>();
        
        for(int[] b : block){
            int x = b[0];
            int y = b[1];
            rotated.add(new int[]{y, -x});
        }
        
        return normalize(rotated);
    }
}