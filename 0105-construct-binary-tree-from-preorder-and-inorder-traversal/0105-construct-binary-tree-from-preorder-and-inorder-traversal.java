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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn, Map<Integer, Integer> map){
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[startPre]);
        
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - startIn;
        
        root.left = buildTree(preorder, startPre + 1, startPre + numsLeft, inorder, startIn, inRoot - 1, map);
        root.right = buildTree(preorder, startPre + numsLeft + 1, endPre, inorder, inRoot + 1, endIn, map);
        
        return root;
    }
}