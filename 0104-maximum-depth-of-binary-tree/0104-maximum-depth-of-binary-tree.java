/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while(!queue.isEmpty()){
            ans++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode x = queue.remove();
                if(x.left != null)
                    queue.add(x.left);
                if(x.right != null)
                    queue.add(x.right);
            }
        }
        return ans;
    
        
    }
}




// public int maxDepth(TreeNode root) {
//         if(root==null){
//             return 0;
//         }
//         int leftdepth = maxDepth(root.left);
//         int rightdepth = maxDepth(root.right);
        
//         return 1 + Math.max(leftdepth, rightdepth);
        
//     }