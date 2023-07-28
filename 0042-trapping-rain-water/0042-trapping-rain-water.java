class Solution {
   public int trap(int[] height){
       int n = height.length;
       int left = 0;
       int leftmax = 0;
       int right = n-1;
       int rightmax = 0;
       int res = 0;
       
       while(left <= right){
           if(height[left] <= height[right]){
               if(height[left] >= leftmax) leftmax = height[left];
               else res += leftmax - height[left];
               left++;
           }
           else{
               if(height[right] >= rightmax){
                   rightmax = height[right];
                   
               }
               else{
                   res+= rightmax - height[right];
                   
               }
               right--;
           }
       }
       return res;
   } 
}

// public int trap(int[] height) {
//         int n = height.length;
//         int[] prefix = new int[n];
//         int[] suffix = new int[n];
//         int max = height[0];
//         for(int i =0; i < n; i++){
//             max = Math.max(max, height[i]);
//             prefix[i] = max;
//         }
//         int max2 = height[n-1];
//         for(int i = n-1; i >=0; i--){
//             max2 = Math.max(max2, height[i]);
//             suffix[i] = max2;
//         }
        
//         int count = 0;
//         for(int i = 0; i < n; i++){
//             count += (Math.min(prefix[i], suffix[i]) - height[i]);
//         }
//         return count;
        
//     }