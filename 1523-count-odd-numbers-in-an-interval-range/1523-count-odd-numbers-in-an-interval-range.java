class Solution {
    public int countOdds(int low, int high) {
        if(low % 2 == 0 && high%2 == 0){
            return (high - low)/2;
        }
        else{
            int l = low % 2 == 0 ? low + 1 : low;
            return ((high - l)/2) + 1;
        }
    }
}