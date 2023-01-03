class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();     
        //backtracking or backtracing
        backtrace(nums,ans,new ArrayList<>(),0);
        return ans;
    }
    public void backtrace(int[] arr,List<List<Integer>> ans,List<Integer> hel,int index){
        // if(index == arr.length){
        //     ans.add(new ArrayList<>(hel));
        //     return;
        // }
        // backtrace(arr,ans,hel,index+1);
        // hel.add(arr[index]);
        // backtrace(arr,ans,hel,index+1);
        // hel.remove(hel.size() - 1);
        
        
        ans.add(new ArrayList<>(hel));
        for(int i = index; i < arr.length; i++){
            hel.add(arr[i]);
            backtrace(arr, ans, hel, i + 1);
            hel.remove(hel.size() - 1);
        }
    }
}