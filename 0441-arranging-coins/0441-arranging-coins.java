class Solution {
    public int arrangeCoins(int n) {
//         int i = 1;
//         while(n > 0){
//             ++i;
//             n -= i;
            
//         }
//         return i-1;
        
        return (int)(Math.sqrt(2*(long)n + 0.25) - 0.5);
    }
}