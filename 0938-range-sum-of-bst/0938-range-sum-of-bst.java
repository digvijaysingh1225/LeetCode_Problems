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
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }
    public int dfs(TreeNode node, int L, int R){
        if(node != null){
            if(L<=node.val && node.val<=R){
                sum += node.val;
            }
            if(L < node.val){
                dfs(node.left, L, R);
            }
            if(node.val < R){
                dfs(node.right, L, R);
            }
        }
        return sum;
    }
}