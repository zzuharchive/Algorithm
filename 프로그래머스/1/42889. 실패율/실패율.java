import java.util.*;
class Stage{
    int stage;
    int fail = 0;
    double pro = 0.0;
    Stage(int stage, int fail){
        this.stage = stage;
        this.fail = fail;
    }
    double getPro(){
        return this.pro;
    }
    int getStage(){
        return this.stage;
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
       
        Stage[] stageArr = new Stage[N];
        for(int i=0; i<stageArr.length; i++){
            stageArr[i] = new Stage(i+1, 0);
        }
        for(int i=0; i<stages.length; i++){
            if(stages[i] <= N) stageArr[stages[i] - 1].fail++;
        }
        
        int lastUser = stages.length;
        
        for(int i=0; i<stageArr.length; i++){
            if(lastUser == 0) stageArr[i].pro = 0.0;
            else{
                stageArr[i].pro = (double)stageArr[i].fail / lastUser;
                lastUser -= stageArr[i].fail;
            }
        }
        
        List<Stage> stageList = Arrays.asList(stageArr);
        stageList.sort(Comparator.comparing(Stage::getPro)
                      .reversed()
                      .thenComparing(Stage::getStage));
        
        return stageList.stream()
            .mapToInt(Stage::getStage)
            .toArray();
    }
}