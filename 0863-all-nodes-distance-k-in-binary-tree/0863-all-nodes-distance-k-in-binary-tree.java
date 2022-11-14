/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, target);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        vis.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(curr_level == k){
                break;
            }
            curr_level++;
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left != null && vis.get(current.left) == null){
                    queue.offer(current.left);
                    vis.put(current.left, true);
                }
                if(current.right != null && vis.get(current.right) == null){
                    queue.offer(current.right);
                    vis.put(current.right, true);
                }
                
                if(parent_track.get(current) != null && vis.get(parent_track.get(current)) == null){
                    queue.offer(parent_track.get(current));
                    vis.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            list.add(curr.val);
        }
        return list;
        
    }
    
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null){
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null){
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
            
        }
    }
    
}