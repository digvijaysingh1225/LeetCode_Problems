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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int startIn, int endIn, int[] postorder, int startPost, int endPost, Map<Integer, Integer> map){
        if(startIn > endIn || startPost > endPost){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[endPost]);
        
        int inRoot = map.get(postorder[endPost]);
        int numsLeft = inRoot - startIn;
        
        root.left = buildTree(inorder, startIn, inRoot - 1, postorder, startPost, startPost + numsLeft - 1, map);
        root.right = buildTree(inorder, inRoot + 1, endIn, postorder, startPost + numsLeft, endPost - 1, map);
        
        return root;
    }
}