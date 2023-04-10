class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
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
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int m  = flights.length;
        for(int i = 0; i < m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        
        while(!q.isEmpty()){
            int stop = q.peek().first;
            int node = q.peek().second;
            int cost = q.peek().third;
            q.remove();
            if(stop > k)
                continue;
            
            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edW  = iter.second;
                
                if(cost + edW < dist[adjNode] && stop <= k){
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stop+1, adjNode, cost+edW));
                }
            }
        }
        if(dist[dst] == (int)(1e9))
             return -1;
        return dist[dst];
    }
    
}
                       
                    
                       
// time complexity = O(V^2*K)

//     int min = Integer.MAX_VALUE;
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int[][] adjMat = new int[n][n];
        
//         for(int[] flight : flights){
//             adjMat[flight[0]][flight[1]] = flight[2];
//         }
        
//         dfs(adjMat, src, dst, k, 0);
        
//         return min==Integer.MAX_VALUE?-1:min;
//     }
//     public void dfs(int[][] adjMat, int src, int dst, int k, int cost){
//         if(src == dst){
//             min = Math.min(min, cost);
//             return;
//         }
//         if(k<0 || cost>=min){
//             return;
//         }
        
//         for(int i = 0; i < adjMat.length; i++){
//             if(adjMat[src][i] != 0 && cost + adjMat[src][i] < min){
//                 dfs(adjMat, i, dst, k-1, cost+adjMat[src][i]);
//             }
//         }
        
        
//     }