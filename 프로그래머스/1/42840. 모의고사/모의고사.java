import java.util.*;

class Record {
    int num;
    int score;
    Record(int num, int score){
        this.num = num;
        this.score = score;
    }
    int getNum () {return num;}
    int getScore () {return score;}
}

class Solution {
    public int[] solution(int[] answers) {
        
        int[] firstMathGiveup = {1,2,3,4,5};
        int[] secondMathGiveup = {2,1,2,3,2,4,2,5};
        int[] thirdMathGiveup = {3,3,1,1,2,2,4,4,5,5};
        
        Record[] record = new Record[3];
        for(int i=0; i<3; i++){
            record[i] = new Record(i+1, 0);
        }
        
        for(int i=0; i<answers.length; i++){
            if (firstMathGiveup[i%5] == answers[i]) record[0].score++;
            if (secondMathGiveup[i%8] == answers[i]) record[1].score++;
            if (thirdMathGiveup[i%10] == answers[i]) record[2].score++;
        }
        
        int maxScore = Arrays.stream(record)
            .mapToInt(Record::getScore)
            .max()
            .getAsInt();
        
        int[] answer = Arrays.stream(record)
            .filter(r -> r.getScore() == maxScore)
            .mapToInt(Record::getNum)
            .sorted()
            .toArray();
        
        return answer;
    }
}