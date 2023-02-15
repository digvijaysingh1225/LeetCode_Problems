class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new LinkedList<>();
        int carry = 0;
        int i = num.length - 1;
        while(i >= 0 || k > 0) {
            int sum = k % 10 + carry;
            if(i >= 0)
            sum += (num[i]);
            ans.add(0, sum % 10);
            carry = sum / 10;
            k /= 10;
            i--;
        }
        if(carry != 0) ans.add(0,carry);
        return ans;
    }
}