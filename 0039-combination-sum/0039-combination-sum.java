class Solution {
    public List<List<Integer>> combinationSum(int[] can, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(tar, comb, 0,can, ans);
        return ans;
    }
     public void backtrack(int tar, LinkedList<Integer> comb, int start, int[] can,
                           List<List<Integer>> ans)
    {
        if(tar == 0)
        {
            ans.add(new ArrayList<Integer>(comb));
            return;
        }
        else if(tar< 0)
        {
            return;
        }
        for(int i= start; i<can.length ; ++i)
        {
            comb.add(can[i]);
            backtrack(tar - can[i], comb, i, can, ans);
            comb.removeLast();
        }
    }
}