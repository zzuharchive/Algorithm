class Solution {
    static int[] rate = new int[]{10,20,30,40};
    static int totalJoin = 0;
    static int totalRevenue = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        dfs(0, emoticons, users, new int[emoticons.length]);
        return new int[]{totalJoin, totalRevenue};
    }
    void dfs(int index, int[] emoticons, int[][] users, int[] discounts){
        if(index == emoticons.length){
            calculate(discounts, emoticons, users);
            return;
        }
        
        for(int i=0; i<rate.length; i++){
            discounts[index] = rate[i];
            dfs(index + 1, emoticons, users, discounts);
        }
    }
    
    void calculate(int[] discounts, int[] emoticons, int[][] users){
        int revenue  = 0;
        int join = 0;
        
        for(int i=0; i<users.length; i++){
            int userRevenue = 0;
            int userJoin = 0;
            
            for(int j = 0; j < emoticons.length; j++){    
                if(users[i][0] <= discounts[j]){
                    userRevenue += emoticons[j] * (100-discounts[j])/100;
                }
            }
            
            if(userRevenue >= users[i][1]) join++;
            else revenue += userRevenue;
        }
        
        if(totalJoin < join){
            totalJoin = join;
            totalRevenue = revenue;
        }else if(totalJoin == join){
            if(totalRevenue < revenue){
                totalJoin = join;
                totalRevenue = revenue;
            }
        }
    }
}