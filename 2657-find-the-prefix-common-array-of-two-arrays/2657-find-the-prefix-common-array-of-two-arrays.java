class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] c = new int[n];
        
        for(int i = 0; i < n; i++){
            boolean found = false;
            for(int j = 0; j < n; j++){
                if(A[i] == B[j]){
                    found = true;                    
                }
                if(found && j >= i){
                    c[j]++;
                }
            }
        }
        return c;
    }
}