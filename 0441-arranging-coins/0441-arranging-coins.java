class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        
//         for(int i = 0; i < n/2; i++){
            
//         }
        int temp = n;
        int i = 1;
        while(temp >= 0){
            temp = temp - i;
            i++;
            count++;
        }
        
        return count-1;
    }
}