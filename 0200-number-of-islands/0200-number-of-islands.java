class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

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


// public static void bfs(int i, int j, int[][] vis, char[][] grid){
//         vis[i][j] = 1;
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(i, j));
//         int n = grid.length;
//         int m = grid[0].length;
//         while(!q.isEmpty()){
//             int row = q.peek().first;
//             int col = q.peek().second;
//             q.remove();
            
//             for(int delrow = -1; delrow <= 1; delrow++){
//                 for(int delcol = -1; delcol <= 1; delcol++){
//                     int nrow = row + delrow;
//                     int ncol = col + delcol;
//                     if(nrow>=0 || nrow<n || ncol>=0 || ncol<m || grid[nrow][ncol]!="0" ||
//                       vis[nrow][ncol] == 0){
//                         vis[nrow][ncol] = 1;
//                         q.add(new Pair(nrow, ncol));
//                     }
//                 }
//             }
//         }
//     }