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
    int max = 0;
    public int maxPathSum(TreeNode root) {
        
        max = Integer.MIN_VALUE;
        int val = maxPath(root);
        return Math.max(max, val);
    }
    public int maxPath(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = Math.max(0, maxPath(node.left));
        int rightSum = Math.max(0, maxPath(node.right));
        max = Math.max(max, node.val+leftSum+rightSum);
        return node.val+Math.max(leftSum, rightSum);
    }
}


 // public int maxPathSum(TreeNode root) {
 //        int[] max = new int[1];
 //        max[0] = Integer.MIN_VALUE;
 //        maxPath(root, max);
 //        return max[0];
 //    }
 //    public int maxPath(TreeNode node, int[] sum){
 //        if(node == null){
 //            return 0;
 //        }
 //        int leftSum = Math.max(0, maxPath(node.left, sum));
 //        int rightSum = Math.max(0, maxPath(node.right, sum));
 //        sum[0] = Math.max(sum[0], node.val+leftSum+rightSum);
 //        return node.val+Math.max(leftSum, rightSum);
 //    }