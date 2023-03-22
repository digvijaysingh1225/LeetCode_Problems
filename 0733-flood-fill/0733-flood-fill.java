class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];
        int[][] temp = image;
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};
        dfs(sr, sc, temp, image, color, delrow, delcol, initColor);
        return temp;
    }
    
    public static void dfs(int sr, int sc, int[][] temp, int[][] image, int color,int[] delrow, int[] delcol, int initColor){
        temp[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0; i < 4; i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
              && image[nrow][ncol] == initColor && temp[nrow][ncol] != color){
                dfs(nrow, ncol, temp, image, color, delrow, delcol, initColor);
            }
        }
    }
}