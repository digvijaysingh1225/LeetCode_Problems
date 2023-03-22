class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        // int row1 = 0;
        // int row2 = matrix.length-1;
        // int col1 = 0;
        // int col2 = matrix[0].length-1;
        
//         while(row1 < row2 && col1 < col2){
            
//             for(int i = col1; i < col2; i++){
//                 result.add(matrix[row1][col1]);
//             }
            
//         }
        
        int i, k=0, l=0;
        while(k<m && l <n){
            for(i = l; i<n;i++){
                result.add(matrix[k][i]);
            
            }
            k++;
            for(i = k; i < m; i++){
                result.add(matrix[i][n-1]);
            }
            n--;
            if(k<m){
                for(i = n-1; i>=l;i--){
                    result.add(matrix[m-1][i]);
                }
                m--;
            }
            if(l<n){
                for(i = m-1; i>=k;i--){
                    result.add(matrix[i][l]);
                }
                l++;
            }
        }
        return result;
        
        // return result;
        
    }
}