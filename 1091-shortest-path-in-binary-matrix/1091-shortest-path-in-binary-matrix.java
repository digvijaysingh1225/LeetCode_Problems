class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if (n == 1 && m == 1) {
            if (grid[0][0] == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        
        
        if(grid[0][0]==1 || grid[n-1][m-1]==1) {
            return -1;
        }
        int[][] dis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dis[i][j] = (int)(1e9);
            }
        }
        dis[0][0] = 1;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(1, 0, 0));
        
        int[] delrow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] delcol = {0, 1, 1, 1, 0, -1, -1, -1};
        
        while(!q.isEmpty()){
            int distance = q.peek().first;
            int row = q.peek().second;
            int col = q.peek().third;
            q.remove();
            
            for(int i = 0; i < 8; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == 0 && distance+1 < dis[nrow][ncol]){
                    dis[nrow][ncol] = 1 + distance;
                    if(nrow == n-1 && ncol == m-1){
                        return distance + 1;
                    }
                    q.add(new Tuple(distance+1, nrow, ncol));
                }
            }
        }
        return -1;
    }
}
