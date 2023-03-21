class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < isConnected.length; i++){
            adjList.add(new ArrayList<>());
            
        }
        
        for(int i = 0; i<isConnected.length; i++){
            for(int j = 0; j < isConnected.length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int[] vis = new int[isConnected.length];
        int count = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(vis[i] == 0){
                count++;
                dfs(i, vis, adjList);
            }
        }
        return count;
    }
    
    
    private static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adjList){
        vis[node] = 1;
        for(Integer it: adjList.get(node)){
            if(vis[it]==0){
                dfs(it, vis, adjList);
            }
        }
    }
}