//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    //BFS
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        // int[] topo = new int[V];
        int count = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            count++;
            
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(count == V) return false;
        return true;
    }
}

//DFS
// public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//         // code here
        
//         int[] vis = new int[V];
//         int[] pathVis = new int[V];
        
//         for(int i = 0; i < V; i++){
//             if(vis[i] == 0){
//                 if(dfs(i, adj, vis, pathVis) == true){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
    
//     private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis){
//         vis[node] = 1;
//         pathVis[node] = 1;
        
//         for(int it: adj.get(node)){
//             //when the node is not visited
//             if(vis[it] == 0){
//                 if(dfs(it, adj, vis, pathVis))
//                     return true;
                
//             }
//             // if the node has been previously visited 
//             // but it has to be visited on the same path
//             else if(pathVis[it] == 1){
//                 return true;
//             }
//         }
//         pathVis[node] = 0;
//         return false;
//     }