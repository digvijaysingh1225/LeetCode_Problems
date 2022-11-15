//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Node , Node> mpp = new HashMap<>();
        Node tar = bfsToMap(root, mpp, target);
        int time = findMaxDistance(mpp, tar);
        return time;
    }
    
    private static Node bfsToMap(Node root, HashMap<Node, Node> mpp, int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node res = new Node(-1);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.data == target)
                res = node;
            if(node.left != null){
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
    
    private static int findMaxDistance(HashMap<Node, Node> mpp, Node target){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        HashMap<Node, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int flag = 0;
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(node.left != null && vis.get(node.left) == null){
                    flag = 1;
                    vis.put(node.left, 1);
                    queue.offer(node.left);
                }
                if(node.right != null && vis.get(node.right) == null){
                    flag = 1;
                    vis.put(node.right, 1);
                    queue.offer(node.right);
                }
                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null){
                    flag = 1;
                    vis.put(mpp.get(node), 1);
                    queue.offer(mpp.get(node));
                }
            }
            if(flag == 1){
                time++;
            }
        }
        return time;
    }
}