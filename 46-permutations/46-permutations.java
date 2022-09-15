class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,ans,new ArrayList<>());
        return ans;
    }
    public void helper(int[] nums, List<List<Integer>> ans,List<Integer> help){
        if(help.size()==nums.length){
            ans.add(new ArrayList<>(help));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(help.contains(nums[i]))
                continue;
            help.add(nums[i]);
            helper(nums,ans,help);
            help.remove(help.size()-1);
        }
        
        
    }
}