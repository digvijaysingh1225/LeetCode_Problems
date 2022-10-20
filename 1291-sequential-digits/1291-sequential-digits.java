class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String digits="123456789";
        for(int i=1;i<=9;i++){
            for(int j=0;j+i<=digits.length();j++){
                String sub = digits.substring(j,j+i);
                int val = Integer.parseInt(sub);
                if(val>=low && val<=high)
                    res.add(val);
            }
        }
        return res;
    }
}