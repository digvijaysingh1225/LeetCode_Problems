class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!hs.containsKey(target-nums[i])){
                hs.put(nums[i], i);
            }
            else{
                res[0] = i;
                res[1] = hs.get(target-nums[i]);
                return res;
            }
        }
        return res;
    }
}