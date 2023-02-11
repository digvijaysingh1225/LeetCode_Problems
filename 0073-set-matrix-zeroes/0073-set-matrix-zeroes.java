class Solution {
    public void setZeroes(int[][] matrix) {
//         boolean col0 = true;
//         int row = matrix.length;
//         int col = matrix[0].length;
        
//         for(int i = 0; i < row; i++){
//             if(matrix[i][0] == 0)
//                 col0 = false;
//             for(int j = 1; j < col; j++){
//                 if(matrix[i][j] == 0){
//                     matrix[i][0] = 0;
//                     matrix[0][j] = 0;
//                 }
//             }
//         }
//         for(int i = row-1; i >=0; i--){
//             for(int j = col-1; j >= 0; j--){
//                 if(matrix[i][0] == 0 || matrix[0][j] == 0){
//                     matrix[i][j] = 0;
//                 }
                
//             }
//             if(col0 == false){
//                 matrix[i][0] = 0;
//             }
//         }
        int m=matrix.length, n=matrix[0].length;
        boolean isRow0=false, isCol0=false;
        
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0)
                isRow0=true;
        }
        
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0)
                isCol0=true;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }
        
        if(isRow0){
            for(int j=0;j<n;j++)
                matrix[0][j]=0;
        }
        
        if(isCol0){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }
    }
}