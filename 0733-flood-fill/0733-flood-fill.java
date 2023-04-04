class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] temp = image;
        int initColor = image[sr][sc];
        
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        dfs(sr, sc, temp, image, initColor, color, delrow, delcol);
        return temp;
    }
    private void dfs(int sr, int sc, int[][] temp, int[][] image, int initColor, int color, int[] delrow, int[] delcol){
        temp[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        
        for(int i = 0; i < 4; i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            while(nrow>=0 && nrow<n && ncol>=0 && ncol<m && temp[nrow][ncol] != color && image[nrow][ncol] == initColor){
                dfs(nrow, ncol, temp, image, initColor, color, delrow, delcol);
            }
        }
    }
}