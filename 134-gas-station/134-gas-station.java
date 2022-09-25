class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int j = -1;
        int curr = 0;
        int total = 0;
        for(int i=0; i<gas.length;i++){
            int diff = gas[i] - cost[i];
            curr+=diff;
            total+=diff;
            if(curr<0){
                j=i;
                curr=0;
            }
        }
        if(total>=0){
            return j+1;
        }
        return -1;
    }
}