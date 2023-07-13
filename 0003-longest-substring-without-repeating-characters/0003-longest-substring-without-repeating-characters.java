class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0;
        int high = 0;
        int n = s.length();
        int len = 0;
        while(high < n){
            if(map.containsKey(s.charAt(high))){
                low = Math.max(map.get(s.charAt(high)) + 1, low);
            }
            map.put(s.charAt(high), high);
            len = Math.max(len, high-low+1);
            high++;
        }
        return len;
    }
}