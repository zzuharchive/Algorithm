class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kNum = "";
        
        while(n > 0){
            
            kNum = (n % k) + kNum;
            n /= k;
        }
        
       String[] parts = kNum.split("0+");
        for(String part:parts){
            if(part.equals(""))continue;
            if(isPrime(part)) answer ++;
        }
        
        return answer;
    }
    
    boolean isPrime(String nowNum){
           
        long num = Long.parseLong(nowNum);
        if(num < 2) return false;
        
        for(long i = 2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}