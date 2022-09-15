class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();     
        subsetHelper(nums,ans,new ArrayList<>(),0);
        return ans;
    }
    public void subsetHelper(int[] arr,List<List<Integer>> ans,List<Integer> hel,int index){
        if(index == arr.length){
            ans.add(new ArrayList<>(hel));
            return;
        }
        subsetHelper(arr,ans,hel,index+1);
        hel.add(arr[index]);
        subsetHelper(arr,ans,hel,index+1);
        hel.remove(hel.size() - 1);
        
    }
}