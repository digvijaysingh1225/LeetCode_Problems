class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int max = height[0];
        for(int i =0; i < n; i++){
            max = Math.max(max, height[i]);
            prefix[i] = max;
        }
        int max2 = height[n-1];
        for(int i = n-1; i >=0; i--){
            max2 = Math.max(max2, height[i]);
            suffix[i] = max2;
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            count += (Math.min(prefix[i], suffix[i]) - height[i]);
        }
        return count;
        
    }
}