class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        transpose(matrix);
        
        swapRows(matrix);
        
    }
    
    public void transpose(int[][] A){
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                
                int temp = 0;
                temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
    }
    public void swapRows(int[][] A){
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = 0;
                temp = A[i][j];
                A[i][j] = A[i][n - j - 1];
                A[i][n - j - 1] = temp;
            }
        }
    }
}