class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(n<=1)
            return 0;
        int count = 0;
        // int prod;
        for(int i = 0;i<=n-1;i++){
            int prod = nums[i];
            if(prod<k)
                count++;
            for(int j = i+1;j<=n-1 && prod<k;j++){
                prod*=nums[j];
                if(prod<k)
                    count++;
            }
        }
        return count;
    }
}