class Solution {
    String b;
    HashMap<String, Integer> mpp;
    List<List<String>> ans;
    private void dfs(String word, List<String> seq){
        if(word.equals(b)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps = mpp.get(word);
        int sz = word.length();
        for(int i = 0; i < sz; i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                char[] replacedCharArray = word.toCharArray();
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);
                if(mpp.containsKey(replacedWord) && mpp.get(replacedWord) + 1 == steps){
                    seq.add(replacedWord);
                    dfs(replacedWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        Set<String> st = new HashSet<>();
        int len = wordList.size();
        for(int i = 0; i < len; i++){
            st.add(wordList.get(i));
        }
        Queue<String> q = new LinkedList<>();
        b = beginWord;
        q.add(beginWord);
        mpp = new HashMap<>();
        mpp.put(beginWord, 1);
        int sizee = beginWord.length();
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek();
            int steps = mpp.get(word);
            q.remove();
            if(word.equals(endWord)) break;
            for(int i = 0; i < sizee; i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord) == true){
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        mpp.put(replacedWord, steps+1);
                    }
                }
            }
        }
        ans = new ArrayList<>();
        if(mpp.containsKey(endWord) == true){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
        
    }
}



// Set<String> st = new HashSet<>();
//         int len = wordList.size();
//         for(int i = 0; i < len; i++){
//             st.add(wordList.get(i));
//         }
//         Queue<ArrayList<String>> q = new LinkedList<>();
        
//         ArrayList<String> ls = new ArrayList<>();
//         ls.add(beginWord);
//         q.add(ls);
//         ArrayList<String> usedOnLevel = new ArrayList<>();
//         usedOnLevel.add(beginWord);
//         int level = 0;
//         List<List<String>> ans = new ArrayList<>();
//         while(q.isEmpty()){
//             ArrayList<String> vec = q.peek();
//             q.remove();
//             // erase all words that has been used in the previous levels to transform
//             if(vec.size() > level){
//                 level++;
//                 for(String it: usedOnLevel){
//                     st.remove(it);
//                 }
//             }
//             String word = vec.get(vec.size() - 1);
//             if(word.equals(endWord)){
//                 // the first sequence where we reached end
//                 if(ans.size() == 0){ 
//                     ans.add(vec);
//                 }
//                 else if(ans.get(0).size() == vec.size()) {
//                     ans.add(vec);
//                 }
//             }
            
//             for(int i = 0; i < word.length(); i++){
//                 for(char c = 'a'; c <= 'z'; c++){
//                     char replacedCharArray[] = word.toCharArray();
//                     replacedCharArray[i] = c;
//                     String replacedWord = new String(replacedCharArray);
//                     if(st.contains(replacedWord) == true){
//                         vec.add(replacedWord);
//                         // Java words as reference
//                         ArrayList<String> temp = new ArrayList<>(vec);
//                         q.add(temp);
//                         //mark as visited on the level
//                         usedOnLevel.add(replacedWord);
//                         vec.remove(vec.size() - 1);
                        
//                     }
//                 }
//             }
            
//         }
//         return ans;