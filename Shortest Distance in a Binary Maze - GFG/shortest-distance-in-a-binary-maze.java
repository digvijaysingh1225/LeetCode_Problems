//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class tuple{
    int first;
    int second;
    int third;
    public tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1])
            return 0;

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dis = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dis[i][j] = (int)1e9;
            }
        }
        dis[source[0]][source[1]] = 0;
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0, source[0], source[1]));
        
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            int dist = q.peek().first;
            int row = q.peek().second;
            int col = q.peek().third;
            q.remove();
            
            for(int i = 0; i <4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && 
                grid[nrow][ncol] == 1 && dist + 1 < dis[nrow][ncol]){
                    dis[nrow][ncol] = 1 + dist;
                    if(nrow == destination[0] && ncol == destination[1])
                    return dist+1;
                    q.add(new tuple(1+dist, nrow, ncol));
                }
            }
        }
        return -1;
    }
}
