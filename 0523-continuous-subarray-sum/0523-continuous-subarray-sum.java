class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int sum = 0;
        while(j<nums.length){
            sum += nums[j];
            sum %= k;
            if(sum == 0 && j > 0){
                return true;
            }
            if(map.containsKey(sum) && j-map.get(sum)>1){
                return true;
            }
            if(!map.containsKey(sum)){
                map.put(sum, j);
            }
            j++;
        }
        return false;
    }
}