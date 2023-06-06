class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] c = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(A[i]);
            set.add(B[i]);
            if(set.size() != (2*(i+1))){
                c[i] = (2*(i+1)) - set.size();
            }
        }
        return c;
    }
}




// int n = A.length;
//         int[] c = new int[n];
        
//         for(int i = 0; i < n; i++){
//             boolean found = false;
//             for(int j = 0; j < n; j++){
//                 if(A[i] == B[j]){
//                     found = true;                    
//                 }
//                 if(found && j >= i){
//                     c[j]++;
//                 }
//             }
//         }
//         return c;