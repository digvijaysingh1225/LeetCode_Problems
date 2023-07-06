class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            result.add(generateRow(i));
        }
        return result;
    }
    public List<Integer> generateRow(int n){
        List<Integer> ans = new ArrayList<>();
        int c = 1;
        ans.add(1);
        for(int i = 1; i < n; i++){
            c = c * (n - i);
            c = c / i;
            ans.add(c);
        }
        return ans;
    }
}