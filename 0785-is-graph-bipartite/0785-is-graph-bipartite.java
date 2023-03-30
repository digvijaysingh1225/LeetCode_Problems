class Solution {
    public boolean isBipartite(int[][] graph){
        int n = graph.length;
        int[] color = new int[n];
        
        for(int i = 0; i < n; i++){
            if(color[i] == 0 && !validColor(graph, color, 1, i)){
                return false;
            }
        }
        return true;
    }
    public boolean validColor(int[][] graph, int[] color, int cur, int node){
        if(color[node] != 0){
            return color[node] == cur;
        }
        color[node] = cur;
        for(int next : graph[node]){
            if(!validColor(graph, color, -cur, next)){
                return false;
            }
        }
        return true;
    }
}



//BFS

// public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
        
//         int[] color = new int[n];
//         for(int i = 0; i < n; i++){
//             if(color[i] != 0)
//                 continue;
            
//             Queue<Integer> q = new LinkedList<>();
//             q.offer(i);
//             color[i] = 1;
            
//             while(!q.isEmpty()){
//                 int cur = q.poll();
//                 for(int next : graph[cur]){
//                     if(color[next] == 0){
//                         color[next] = -color[cur];
//                         q.offer(next);
                        
//                     }
//                     else if(color[next] != -color[cur]){
//                         return false;
//                     }
//                 }
//             }
//         }

//         return true;
        
//     }