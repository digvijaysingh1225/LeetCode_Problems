class Solution {
    public int removeDuplicates(int[] nums) {
        int arrayLength = nums.length;
        int j=1;
        for(int i=0;i<arrayLength-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[j]=nums[i+1];
                j++;
            }
        }
        return j;
    }
}