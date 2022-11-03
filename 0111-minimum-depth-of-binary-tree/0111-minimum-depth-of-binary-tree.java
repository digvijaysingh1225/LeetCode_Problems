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
    public int minDepth(TreeNode root) {    
        return helper(root);        
    }
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int lh = helper(node.left);
        int rh = helper(node.right);
        return (lh == 0 || rh == 0) ? lh+rh+1 : Math.min(lh,rh)+1;
    }
}