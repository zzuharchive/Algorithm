class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int i=0;
        while(i<s.length()){
            
            char answerChar=s.charAt(i);
            for(int copyIndex=index;copyIndex>0;copyIndex--){
                answerChar+=1;
                if(answerChar>=123){
                    answerChar-=26;
                }
                for(int j=0;j<skip.length();j++){
                    if(answerChar==skip.charAt(j)){
                        copyIndex+=1;
                        break;
                    }
                }
            }
            answer+=answerChar;
            i++;
        }
        return answer;
    }
}