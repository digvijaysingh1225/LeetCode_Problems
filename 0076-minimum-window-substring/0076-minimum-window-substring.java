class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        int i = 0;
        int j = 0;
        int count = map.size();
        int min = Integer.MAX_VALUE;
        String ans = "";
        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0){
                    count--;
                }
            }
            if(count == 0){
                while(count == 0){
                    if(min > j-i+1){
                        ans = s.substring(i, j+1);
                        min = Math.min(min, j-i+1);   
                    }
                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i), map.get(s.charAt(i))+1);
                        if(map.get(s.charAt(i)) == 1){
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;            
        }
        return ans;
    }
}