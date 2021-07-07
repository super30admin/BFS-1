// Using BFS
// Time Complexity - O(n) where n is the number of nodes
// Space Complexity - O(h) where h is the height of the tree, since at one time maximum there will be nodes in queue equal to the height of the tree
// This solution worked on LeetCode

// We are implementing the Binary Tree Level Order Traversal using BFS where the queue is used to maintain the level order. queue size will be used to keep track of the width of the level. 

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;     // If root is null return empty list of list
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); // Add the root first to the queue
        while(!q.isEmpty()){    // Process until the queue is empty
            int size = q.size();    // Check the number of elements in the queue which will be in that level 
            ArrayList<Integer> levelList = new ArrayList<>(); 
            for(int i=0;i<size;i++){    // Iterate and poll the nodes from queue for size times
                TreeNode node = q.poll(); // poll the node and add the node value to the list
                levelList.add(node.val);
                if(node.left != null) q.add(node.left); // Add the left child node of this node to the queue
                if(node.right != null) q.add(node.right); // Add the right child node of this node to the queue
            }
            res.add(levelList); // the list created for the size number of elements are one level add the levellist to the result list
        }
        return res;     //return the result list in the end after all the queue nodes are processed
    }
}

