class Solution {
    public int findCenter(int[][] edges) {
        
        // This method is incomplete
        // Set<Integer> outEdgesFound = new HashSet<>();
        // for(int[] edge : edges){
        //     if(outEdgesFound.contains(edge[0])){
        //         return edge[0];
        //     }
        //     outEdgesFound.add(edge[0]);
        //     if(outEdgesFound.contains(edge[1]))
        // }
// Incomplete
//         int a = edges[0][0];
//         int b = edges[0][1];
//         int c = edges[1][0];
//         int d = edges[1][1];
        
        
        if(edges[0][0] == edges[1][0] ||
            edges[0][0] == edges[1][1]){
            return edges[0][0];    
        }
        return edges[0][1];
        
    }
}


// public int findCenter(int[][] edges) {
//         int edge = edges.length + 1;
//         int[] arr = new int[edge + 1];
//         for(int[] e: edges){
//             int x  = e[0];
//             int y = e[1];
//             arr[x]++;
//             arr[y]++;
//             if(arr[x] > 1){
//                 return x;
//             }
//             if(arr[y] > 1){
//                 return y;
//             }
//         }
//         return 0;
//     }