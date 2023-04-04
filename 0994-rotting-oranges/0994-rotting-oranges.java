class Pair{
    int row;
    int col;
    int time;
    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
        
    }
}

class Solution {
    
    public int orangesRotting(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        int[][] vis = new int[n][m];
        int countFresh = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                
                if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }
        
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        int t = 0;
        int count = 0;
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            
            t = Math.max(t, time);
            q.remove();
            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                while(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 2;
                    q.add(new Pair(nrow, ncol, time+1));
                    count++;
                }
            }
        }
        
        if(count != countFresh){
            return -1;
        }
        return t;
    }
    
    
}








// public int orangesRotting(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         Queue<Pair> q = new LinkedList<>();
        
//         int countFresh = 0;
//         int[][] vis = new int[n][m];
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < m; j++){
//                 if(grid[i][j] == 2){
//                     q.add(new Pair(i, j, 0));
//                     vis[i][j] = 2;
//                 }
//                 else{
//                     vis[i][j] = 0;
//                 }
                
//                 if(grid[i][j] == 1){
//                     countFresh++;
//                 }
//             }
//         }
        
//         int count = 0;
//         int time = 0;
//         int[] delrow = {-1, 0, +1, 0};
//         int[] delcol = {0, +1, 0, -1};
//         while(!q.isEmpty()){
//             int r = q.peek().row;
//             int c = q.peek().col;
//             int t = q.peek().time;
//             time = Math.max(time, t);
//             q.remove();
//             for(int i = 0; i < 4; i++){
//                 int nrow = r + delrow[i];
//                 int ncol = c + delcol[i];
                
//                 if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
//                     q.add(new Pair(nrow, ncol, t+1));
//                     vis[nrow][ncol] = 2;
//                     count++;
//                 }
//             }
//         }
//         if(count != countFresh) return -1;
//         return time;
        
        
        

//     }