class Solution {
    public int findCircleNum(int[][] M) {
        
        int[] vis = new int[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++){
            if(vis[i] == 0){
                dfs(i, vis, M);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int i, int[] vis, int[][] M){
        for(int j = 0; j < M.length; j++){
            if(M[i][j] == 1 && vis[j] == 0){
                vis[j] = 1;
                dfs(j, vis, M);
            }
        }
    }
        
}
    
    
    

    
    
// Converting Adjacency Matrix into List
//         ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
//         for(int i = 0; i < isConnected.length; i++){
//             adjList.add(new ArrayList<>());
            
//         }
        
//         for(int i = 0; i<isConnected.length; i++){
//             for(int j = 0; j < isConnected.length; j++){
//                 if(isConnected[i][j] == 1 && i != j){
//                     adjList.get(i).add(j);
//                     adjList.get(j).add(i);
//                 }
//             }
//         }
//         int[] vis = new int[isConnected.length];
//         int count = 0;
//         for(int i = 0; i < isConnected.length; i++){
//             if(vis[i] == 0){
//                 count++;
//                 dfs(i, vis, adjList);
//             }
//         }
//         return count;
//     }
    
    
//     private static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adjList){
//         vis[node] = 1;
//         for(Integer it: adjList.get(node)){
//             if(vis[it]==0){
//                 dfs(it, vis, adjList);
//             }
//         }
//     }