class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        long x = (long)n;
        x = n&(n-1);
        return (x==0);
    }
}