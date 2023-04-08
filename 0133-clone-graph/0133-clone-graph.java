/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return helper(node, new HashMap<>());
    }
    public Node helper(Node node, HashMap<Node, Node> vis){
        if(node == null){
            return null;
        }
        if(vis.containsKey(node)){
            return vis.get(node);
        }
        Node newNode = new Node(node.val);
        vis.put(node, newNode);
        
        for(Node n : node.neighbors){
            newNode.neighbors.add(helper(n, vis));
        }
        
        return newNode;
    }
}