class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s = 0;
        int l = nums.length -1;
        while(s<l){
            int m = s+(l-s)/2;
            if((m%2==0 && nums[m] == nums[m+1]) || (m%2==1 && nums[m] == nums[m-1])){
                s = m+1;
            }
            else{
                l = m;
            }
        }
        return nums[s];
    }
}