class Solution {
    static int answer = 0;
   
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    static void dfs(int[] numbers, int target, int depth, int currentSum){
        if(depth == numbers.length){
            if(currentSum == target) answer++;
            return;
        }
        
        dfs(numbers, target, depth+1, currentSum+numbers[depth]);
        dfs(numbers, target, depth+1, currentSum-numbers[depth]);
    }
}