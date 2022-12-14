class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while(start<=end){
            long mid = start + (end - start)/2;
            if(mid * mid == num){
                return true;
            }
            if(mid * mid > num){
                end = (int)mid - 1;
            }
            if(mid * mid < num){
                start = (int)mid + 1;
            }
        }
        return false;
    }
}