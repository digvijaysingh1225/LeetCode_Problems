class Solution {
    public int majorityElement(int[] nums) {
        int n = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            count += nums[i] == nums[n] ? 1 : -1;
            if(count == 0){
                n = ++i;
                count += 1;
            }
        }
        return nums[n];
    }
}