class Solution {
    public int maximum69Number (int num) {
        int placeValueSix = -1;
        int placeValue = 0;
        int temp = num;
        while(temp > 0){
            int rem = temp%10;
            if(rem == 6){
                placeValueSix = placeValue;
            }
            temp = temp/10;
            placeValue++;
        }
        return (placeValueSix == -1) ? num : num + 3 * (int)Math.pow(10, placeValueSix);
    }
}