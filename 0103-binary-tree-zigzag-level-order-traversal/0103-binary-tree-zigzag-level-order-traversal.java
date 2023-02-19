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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> res =new ArrayList<>();
        if(root==null)
            return res;
        zigzag(root,res,0);
        return res;
    }
    static void zigzag(TreeNode root,List<List<Integer>> res,int level){
        if(root==null)
            return;
        if(res.size()<=level){
            LinkedList<Integer> lis = new LinkedList<>();
            res.add(lis);
        }
            
        if(level%2==0)
            res.get(level).add(root.val);
        else
            res.get(level).add(0,root.val);
        zigzag(root.left,res,level+1);
        zigzag(root.right,res,level+1);
    }
}