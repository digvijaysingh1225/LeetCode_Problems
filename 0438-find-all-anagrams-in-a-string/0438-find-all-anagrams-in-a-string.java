class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int i = 0;
        int j = 0;
        int count = map.size();
        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0){
                    count--;
                }
            }
            if(j-i+1 < p.length()){
                j++;
            }
            else if(j-i+1 == p.length()){
                if(count == 0){
                    list.add(i);
                }
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i))==1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return list;
    }
}