class Solution {
    public int arrangeCoins(int n) {
//         int i = 1;
//         while(n > 0){
//             ++i;
//             n -= i;
            
//         }
//         return i-1;
        
        // return (int)(Math.sqrt(2*(long)n + 0.25) - 0.5);
        
        long left = 0;
        long right = n;
        long ans = 0;
            
        while(left <= right){
            long mid = (right + left)>>1;
            if((mid)*(mid+1)/2 <=n){
                ans = mid;
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }
        return (int)ans;
    }
}