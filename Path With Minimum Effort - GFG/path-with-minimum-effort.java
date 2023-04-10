//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

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
    
    int MinimumEffort(int heights[][]) {
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] dis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dis[i][j] = (int)(1e9);
            }
        }
        dis[0][0] = 0;
        PriorityQueue<Tuple> q = 
        new PriorityQueue<>((x, y) -> x.first - y.first);
        
        q.add(new Tuple(0,  0, 0));
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            int diff = q.peek().first;
            int row = q.peek().second;
            int col = q.peek().third;
            q.remove(); 
            if(row == n-1 && col == m-1) return diff;
            
            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m){
                    int newEffort = Math.max(Math.abs(heights[row][col] - 
                    heights[nrow][ncol]), diff);
                    if(newEffort < dis[nrow][ncol]){
                        dis[nrow][ncol] = newEffort;
                        q.add(new Tuple(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}