class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            hs.add(nums[i]);
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            if(!hs.contains(nums[i]-1)){
                int curNum = nums[i];
                int cnt = 1;
                while(hs.contains(curNum+1)){
                    curNum++;
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
            
        }
        return max;
        
    }
}