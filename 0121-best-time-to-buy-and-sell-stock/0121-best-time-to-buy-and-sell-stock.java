class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1; i < n; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(maxProfit < prices[i]-minPrice){
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}