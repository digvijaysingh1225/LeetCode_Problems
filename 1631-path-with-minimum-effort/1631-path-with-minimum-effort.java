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
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        int[][] dis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dis[i][j] = (int)(1e9);
            }
        }
        
        dis[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.first - y.first);
        pq.add(new Tuple(0, 0, 0));
        
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        while(!pq.isEmpty()){
            int diff = pq.peek().first;
            int row = pq.peek().second;
            int col = pq.peek().third;
            pq.remove();
            if(row == n-1 && col == m-1) return diff;
            
            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m){
                    int minEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    if(minEffort < dis[nrow][ncol]){
                        dis[nrow][ncol] = minEffort;
                        pq.add(new Tuple(minEffort, nrow, ncol));
                    }
                }
            }
        }
        return 0;
        
    }
}