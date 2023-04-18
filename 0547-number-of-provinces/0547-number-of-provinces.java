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





//Other method
// public int findCircleNum(int[][] M) {
        
//         int[] vis = new int[M.length];
//         int count = 0;
//         for(int i = 0; i < M.length; i++){
//             if(vis[i] == 0){
//                 dfs(i, vis, M);
//                 count++;
//             }
//         }
//         return count;
//     }
    
//     public void dfs(int i, int[] vis, int[][] M){
//         for(int j = 0; j < M.length; j++){
//             if(M[i][j] == 1 && vis[j] == 0){
//                 vis[j] = 1;
//                 dfs(j, vis, M);
//             }
//         }
//     }


//Disjoint method not working currently
// public int findCircleNum(int[][] M){
//        int n = M.length;
//        DisjointSet ds = new DisjointSet(n);
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                if(M[i][j] == 1){
//                    ds.unionBySize(i, j);
//                }
//            }
//        }
//        int cnt = 0;
//        for(int i = 0; i < n; i++){
//            if(ds.parent.get(i) == i) cnt++;
           
//        }
//        return cnt;
//    }
        
// }
// class DisjointSet{
//     List<Integer> rank = new ArrayList<>();
//     List<Integer> parent = new ArrayList<>();
//     List<Integer> size = new ArrayList<>();
//     public DisjointSet(int n){
//         for(int i = 0; i <= n; i++){
//             rank.add(0);
//             parent.add(i);
//         }
//     }
    
//     public int findUPar(int node){
//         if(node == parent.get(node)){
//             return node;
//         }
//         int ulp = findUPar(parent.get(node));
//         parent.set(node, ulp);
//         return parent.get(node);
//     }
    
//     public void unionByRank(int u, int v){
//         int ulp_u = findUPar(u);
//         int ulp_v = findUPar(v);
//         if(ulp_u == ulp_v){
//             return;
//         }
//         if(rank.get(ulp_u) < rank.get(ulp_v)){
//             parent.set(ulp_u, ulp_v);
//         }
//         else if(rank.get(ulp_v) < rank.get(ulp_v)){
//             parent.set(ulp_v, ulp_u);
//         }
//         else{
//             parent.set(ulp_v, ulp_u);
//             int rankU = rank.get(ulp_u);
//             rank.set(ulp_u, rankU + 1);
//         }
//     }
    
//     public void unionBySize(int u, int v){
//         int ulp_u = findUPar(u);
//         int ulp_v = findUPar(v);
//         if(ulp_u == ulp_v){
//             return;
//         }
//         if(size.get(ulp_u) < size.get(ulp_v)){
//             parent.set(ulp_u, ulp_v);
//             size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
//         }
//         else{
//             parent.set(ulp_v, ulp_u);
//             size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
//         }
//     }