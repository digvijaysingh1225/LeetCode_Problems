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
    
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack  =  new Stack<TreeNode>();
        if(node==null){
            return ans;
        }
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            ans.add(temp.val);
            stack.pop();
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
        return ans;
        
    
    }
}