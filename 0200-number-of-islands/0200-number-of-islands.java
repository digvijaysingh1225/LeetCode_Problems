class Solution {
    public int numIslands(char[][] grid) {
        int m=grid[0].length;
        int n=grid.length;
        boolean vis[][] = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return count;

    }
    static void dfs(int i,int j,boolean[][] vis,char[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j]=='0'){
            return;
        }
        
        vis[i][j]=true;
        dfs(i-1,j,vis,grid);
        dfs(i+1,j,vis,grid);
        dfs(i,j-1,vis,grid);
        dfs(i,j+1,vis,grid);
    }
}