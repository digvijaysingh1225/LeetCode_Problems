class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            result.add(generateRows(i));
        }
        return result;
    }
    public List<Integer> generateRows(int n){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int c = 1;
        for(int i = 1; i < n; i++){
            c = c * (n - i);
            c = c/i;
            ans.add(c);
        }
        return ans;
    }
}