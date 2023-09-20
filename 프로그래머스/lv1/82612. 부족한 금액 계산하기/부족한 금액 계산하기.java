class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sumPrice=0;
        for(int i=1;i<=count;i++){
            sumPrice+=price*i;
        }
        if(sumPrice<=money) return 0;
        answer*=(money-sumPrice);
        return answer;
    }
}