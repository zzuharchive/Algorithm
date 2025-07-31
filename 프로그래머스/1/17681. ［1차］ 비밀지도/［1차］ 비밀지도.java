class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
      
        String[] integration = new String[n];
        
        for(int i=0; i<n; i++){
            int bitIntegration = arr1[i] | arr2[i];
            String bitToString = String.format("%"+n+"s", Integer.toBinaryString(bitIntegration));
            bitToString = bitToString.replace("0", " ").replace("1", "#");
            integration[i] = bitToString;
        }
        return integration;
    }
}