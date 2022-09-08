class Solution {
    public int addDigits(int num) {
        if(num==0)
            return 0;
        int sum = 0;
        while(num>0){
            int rem = num%10;
            sum+=rem;
            num/=10;
        }
        if(sum<10){
            return sum;
        }
        else{
            return addDigits(sum);
        }
    }
}