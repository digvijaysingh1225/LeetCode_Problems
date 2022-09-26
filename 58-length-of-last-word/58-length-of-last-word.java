class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        char[] ch = s.toCharArray();
        int n =ch.length-1;
        for(int i=n; i>=0; i--){
            if(ch[i]!=' '){
                count++;
            }
            else{
                if(count>0){
                    return count;
                }
            }
        }
        return count;
    }
}