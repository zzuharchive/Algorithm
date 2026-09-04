class Solution {
    public int[] solution(int n, int m) {
        
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int gcdVal = gcd(max, min);
        int[] answer = {gcdVal, n*m/gcdVal};
        return answer;
    }
    public int gcd(int bigger, int num){
        int mod = bigger % num;
        if (mod == 0) return num;
        return gcd(num, mod);
    }

}