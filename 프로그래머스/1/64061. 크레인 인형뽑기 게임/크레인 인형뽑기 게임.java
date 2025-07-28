import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        List<Stack<Integer>> boardStack = new ArrayList<>();
        Stack<Integer> bucket = new Stack<>();
        
        for(int i = 0; i<board.length; i++){
            boardStack.add(new Stack<>());
        }
        
        for(int j=0; j<board.length; j++){
            for(int i = board.length - 1; i>=0; i--){
                if(board[i][j] != 0) {
                    boardStack.get(j).add(board[i][j]);
                }
            }
        }        
        
        for(int i=0; i<moves.length; i++){
            int now = moves[i] - 1;
            if(boardStack.get(now).size() == 0) continue;
            bucket.add(boardStack.get(now).pop());
            if(bucket.size() >= 2){
                if(bucket.get(bucket.size()-1) == bucket.get(bucket.size()-2)){
                    bucket.pop();
                    bucket.pop();
                    answer += 2;
                }
            }
        }
        return answer;
    }
}