class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0; i < trust.length; i++){
            int a = trust[i][0];
            int b = trust[i][1];
            arr1[a-1]++;
            arr2[b-1]++;
            
        }
        for(int i = 0; i < n; i++){
            if(arr1[i] == 0 && arr2[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}