class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for(int i : weights){
            start = Math.max(start, i);
            end += i;
        }
        int mid;
        int ans = end;
        while(start<=end){
            mid = start+(end-start)/2;
            if(check(weights, days, mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
    }
    
    public boolean check(int[] weights, int days, int capacity){
        int reqDays = 1;
        int curWt = 0;
        for(int i:weights){
            if(curWt+i > capacity){
                reqDays++;
                curWt = 0;
            }
            curWt += i;
        }
        if(reqDays > days)
            return false;
        return true;
    }
}