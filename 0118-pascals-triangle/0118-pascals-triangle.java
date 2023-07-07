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
        
        ans.add(1);
        int cnt = 1;
        for(int i = 1; i < n; i++){
            cnt = cnt * ( n - i);
            cnt = cnt/i;
            ans.add(cnt);
        }
        return ans;
        
    }
}